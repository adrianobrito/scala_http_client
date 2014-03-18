package dev.scala.httpclient

import org.scalatest.BeforeAndAfter
import org.scalatest.FlatSpec
import org.scalatest.Matchers

class ResponseSpec extends FlatSpec with Matchers
									with BeforeAndAfter{

  val request:Request = new HttpClient().get("http://localhost:8080/httptest/get");;
  
  "The Response " should " have the response content" in {
	  
  } 
  
  "The Response " should "have the status code" in {
    
  }
  
  "The Response " should "format the response to a object" in {
    
  }
  
}