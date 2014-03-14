package dev.scala.httpclient

import java.net.HttpURLConnection
import java.io.BufferedWriter
import java.io.OutputStream
import java.net.URL
import java.io.OutputStreamWriter
import scala.io.Source._

class Request(url:String, method:String, 
          	  val timeout:Int, 
          	  var _data:String = null,
          	  var _params:Map[String,String] = null, 
          	  var _headers:Map[String,String] = null) {

  implicit def httpConnectionToParametrizedHttpConnection(conn:HttpURLConnection) = new ParametrizedHttpURLConnection(conn)
  
  def params(map:Map[String,String]):Request = {
    _params = map;
    this
  }
  
  def headers(map:Map[String,String]):Request = {
    _headers = map;
    this
  }
  
  def data(content:String):Request = {
    _data = content;
    this
  }
  
  def execute():Response = {
    val connection: HttpURLConnection = HttpURLConnectionFactory.getConnection(url, timeout);
    connection.setRequestMethod(method);
    
    if(_headers != null)
      connection.setRequestHeaders(_headers)
    else
      _headers = Map[String,String]()
      
    if(_params != null){
      connection.setDoOutput(true)
      _headers += ("Content-Type" -> "application/x-www-form-urlencoded")
      _headers += ("charset" -> "utf-8")
      connection.sendParameters(_params)
    }
    
    val responseContent: String = fromInputStream(connection.getInputStream()).getLines().mkString("\n")
    val response: Response = new Response(responseContent, connection.getResponseCode, connection.getResponseMessage);
    
    connection.disconnect();
    response
  }
  

}

object HttpURLConnectionFactory{
  
  def getConnection(url:String, timeout:Int):HttpURLConnection = {
    val connection: HttpURLConnection = new URL(url).openConnection().asInstanceOf[HttpURLConnection];
    connection.setDoInput(true);
    connection.setUseCaches(false);
    connection.setConnectTimeout(timeout * 1000);
    connection.setReadTimeout(timeout * 1000);
    connection
  }
  
}

class ParametrizedHttpURLConnection(val connection:HttpURLConnection){
  def sendParameters(map:Map[String,String]) {
    var first:Boolean = true;
    val result:StringBuilder = new StringBuilder();
    map.foreach{ case (key,value) => {
    		if(first) first = true;
    		else result.append("&");
    		
    		result.append(key, "UTF-8")
    			  .append("=")
    			  .append(value, "UTF-8")
    	} 
    }
    
    val outputStream:OutputStream = connection.getOutputStream()
    val bufferedWriter:BufferedWriter =
    			   new BufferedWriter(new OutputStreamWriter(outputStream))
    bufferedWriter.write(result.toString)
    bufferedWriter.flush()
    bufferedWriter.close()
    outputStream.close()
    
    connection.disconnect()
    connection.setRequestProperty("Content-Length", result.toString.getBytes.length.toString)
    connection.connect();
  } 
  
  def setRequestHeaders(headers:Map[String, String]){
    headers.foreach{ case (key,value) => 
    		connection.setRequestProperty(key, value);
    }
  }
}