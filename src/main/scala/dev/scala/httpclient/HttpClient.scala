package dev.scala.httpclient

import scala.collection.immutable.Map
import java.net.HttpURLConnection
import java.net.URL
import scala.io.Source._
import java.net.URLEncoder
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.OutputStream

class HttpClient(timeout: Int = 10) {

  implicit def httpConnectionToParametrizedHttpConnection(conn:HttpURLConnection) = new ParametrizedHttpURLConnection(conn)
  
  def get(url: String, params: Map[String, String] = null, headers:Map[String, String] = null): Response = {
    executeRequest(url, "GET" ,params, headers)
  }
  
  def post(url: String, params: Map[String, String] = null, headers:Map[String, String] = null):Response = {
    executeRequest(url, "POST" ,params, headers)
  }
 
  private def executeRequest(url: String, method:String ,params: Map[String,String], headers: Map[String,String]): Response = {
    val connection: HttpURLConnection = HttpURLConnectionFactory.getConnection(url, timeout);
    connection.setRequestMethod(method);
    
    if(params != null)
      connection.sendParameters(params)
    
    if(headers != null)
      connection.setRequestHeaders(headers)

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
    connection.setDoOutput(true);
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
    		
    		result.append(URLEncoder.encode(key), "UTF-8")
    			  .append("=")
    			  .append(URLEncoder.encode(value), "UTF-8")    		      
    	} 
    }
    
    val outputStream:OutputStream = connection.getOutputStream()
    val bufferedWriter:BufferedWriter =
    			   new BufferedWriter(new OutputStreamWriter(outputStream))
    bufferedWriter.write(result.toString)
    bufferedWriter.flush()
    bufferedWriter.close()
    outputStream.close()
    connection.connect();
    
  } 
  
  def setRequestHeaders(headers:Map[String, String]){
    headers.foreach{ case (key,value) => 
    		connection.setRequestProperty(key, value);
    }
  }
}