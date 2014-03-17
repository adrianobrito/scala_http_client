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
	  
	  When("The HttpClient invoke a GET REQUEST for a URL at [localhost/get] resource hosted in localhost " + 
			  "and receive a response")
	  val response:Response = httpClient 
	  							.get("http://localhost:8080/httptest/get")
	  							.execute
	  
	  Then("The Response should have code 200")
	  response.statusCode should be (200)
	}
	
	it should " invoke GET requests with parameters to a remote server" in {
	  Given("A HttpClient")
	  val httpClient:HttpClient = new HttpClient
	  
	  When("The HttpClient invoke a GET REQUEST with parameters for a URL at [httptest/get] resource, " + 
			  "hosted in localhost  and receive a response")
	  val response:Response = httpClient 
	  							.get("http://localhost:8080/httptest/get")
	  							.params(Map("teste" -> "teste"))
	  							.execute
	  							
	  println(response)
	  
	  Then("The Response should have code 200")
	  response.statusCode should be (200)
	}
	
	it should " invoke GET requests with Request Headers to a remote server" in {
	  Given("A HttpClient")
	  val httpClient:HttpClient = new HttpClient
	  
	  When("The HttpClient invoke a GET REQUEST with Request Headers for a URL at [httptest/get] resource, " + 
			  "hosted in localhost  and receive a response")
	  val response:Response = httpClient 
	  							.get("http://localhost:8080/httptest/get")
	  							.headers(Map("accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;"))
	  							.execute
	  
	  Then("The Response should have code 200")
	  response.statusCode should be (200)
	}
	
	it should " invoke GET requests with parameters, Request Headers to a remote server" in{
	  Given("A HttpClient")
	  val httpClient:HttpClient = new HttpClient
	  
	  When("The HttpClient invoke a GET REQUEST with Parameters and Request Headers for a URL at [httptest/get] resource, " + 
			  "hosted in localhost  and receive a response")
	  val response:Response = httpClient 
	  							.get("http://localhost:8080/httptest/get")
	  							.params(Map("teste" -> "teste"))
	  							.headers(Map("accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;"))
	  							.execute
	  							
	  Then("The Response should have code 200")
	  response.statusCode should be (200)
	}
	
	it should " invoke POST requests with parameters to a remote server "in {
		Given("A HttpClient")
		val httpClient:HttpClient = new HttpClient
		
		When("A HttpClient invoke a POST REQUEST with parameters for a URL at [httptest/post] resource, " +
		     "hosted in localhost and receive a response")
		val response:Response = httpClient.post("http://localhost:8080/httptest/post")
										  .params(Map("usuario" -> "adrianos", "senha" -> "supertime"))
										  .execute
		
		Then("The Response should have code 200")
		response.statusCode should be (200)
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
