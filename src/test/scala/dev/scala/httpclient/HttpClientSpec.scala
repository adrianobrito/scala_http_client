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
	  
	  When("The HttpClient invoke a GET REQUEST for a URL at [google.com.br] resource hosted in localhost " + 
			  "and receive a response")
	  val response:Response = httpClient.get("http://pontoastin.seduc.ce.gov.br/pontoastin/funcionarios/login")
	  
	  Then("The Response should have code 200")
	  response.statusCode should be (200)
	}
	
	it should " invoke GET requests with parameters to a remote server" in {
	  Given("A HttpClient")
	  val httpClient:HttpClient = new HttpClient
	  
	  When("The HttpClient invoke a GET REQUEST with parameters for a URL at [google.com.br] resource, " + 
			  "hosted in localhost  and receive a response")
	  val response:Response = httpClient.get("http://pontoastin.seduc.ce.gov.br/pontoastin/funcionarios/login",
			  								 Map("teste" -> "Adriano"))
	  
	  Then("The Response should have code 200")
	  response.statusCode should be (200)
	}
	
	it should " invoke GET requests with Request Headers to a remote server" in {
	  Given("A HttpClient")
	  val httpClient:HttpClient = new HttpClient
	  
	  When("The HttpClient invoke a GET REQUEST with Request Headers for a URL at [google.com.br] resource, " + 
			  "hosted in localhost  and receive a response")
	  val response:Response = httpClient.get(url = "http://pontoastin.seduc.ce.gov.br/pontoastin/funcionarios/login",
			  								 headers = Map("accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;"))
	  
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
