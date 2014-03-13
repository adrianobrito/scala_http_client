package dev.scala.httpclient

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.BeforeAndAfter
import org.scalatest.GivenWhenThen

class HttpClientSpec extends FlatSpec with Matchers
									  with GivenWhenThen{
  
	"The HttpClient " should " invoke GET requests to a remote server "in {
	  Given("A HttpClient")
	  val httpClient:HttpClient = new HttpClient
	  
	  When("The HttpClient invoke a GET REQUEST for a URL at test/listar app hosted in localhost " + 
			  "and receive a response")
	  val response:Response = httpClient.get("test/listar")
	  
	  Then("The Response should have code 200")
	  response.statusCode should be (200)
	}
	
	it should " invoke POST requests to a remote server "in {
	  
	}
	
	it should " invoke PUT requests to a remote server "in {
	  
	}
	
	it should " invoke DELETE requests to a remote server "in {
	  
	}
	
	it should " invoke HEAD requests to a remote server "in {
	  
	}
	
	it should " invoke TRACE requests to a remote server "in {
	  
	}
	
	it should " invoke OPTIONS requests to a remote server "in {
	  
	}
	
	it should " invoke CONNECT requests to a remote server "in {
	  
	}
  

}
