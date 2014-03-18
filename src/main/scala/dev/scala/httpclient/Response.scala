package dev.scala.httpclient

import java.io.BufferedWriter
import java.net.HttpURLConnection
import java.io.OutputStream
import java.net.URL
import java.io.OutputStreamWriter

class Response(content:String, val statusCode:Int, val message:String){
	
  override def toString():String = content
  
  def format_to[T](formatter:(String) => T):T ={
    formatter(content)
  }
  
}

