package dev.scala.httpclient

class Response(content:String, val statusCode:Int, message:String){
	
  override def toString():String = content
  
}