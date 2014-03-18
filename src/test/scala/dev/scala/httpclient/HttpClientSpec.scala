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
	
	it should "invoke POST requests to a remote server" in {
	  Given("A HttpClient")
	  val httpClient = new HttpClient
	  
	  When("The HttpClient invoke a POST REQUEST for a URL at [localhost/get] resource hosted in localhost " + 
			  "and receive a response")
	  val response:Response = httpClient
	  							.post("http://localhost:8080/httptest/post")
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
	
	it should " invoke a POST REQUEST with JSON data to a remote server " in{
		Given("A HttpClient")
		val httpClient:HttpClient = new HttpClient
		
		When("A HttpClient invoke a POST REQUEST with JSON data for a URL at [httptest/post] resource, " +
		     "hosted in localhost and receive a response")
		val response:Response = httpClient.post("http://localhost:8080/httptest/post")
										  .data("{nome: 'Adriano Brito', cpf: '0382378'}")
										  .headers(Map("Content-Type" -> "application/json"))
										  .execute
		
		Then("The Response should have code 200")
		response.statusCode should be (200)
	} 
	
	it should " invoke PUT requests with params to a remote server "in {
		Given("A HttpClient")
		val httpClient:HttpClient = new HttpClient
		
		When("A HttpClient invoke a PUT REQUEST with params for a URL at [httptest/put] resource, " +
		     "hosted in localhost and receive a response")
		val response:Response = httpClient.put("http://localhost:8080/httptest/put")
										  .params(Map("usuario" -> "adrianos", "senha" -> "supertime"))
										  .execute
		
		Then("The Response should have code 200")
		response.statusCode should be (200)
	}
	
	it should " invoke PUT requests with JSON data to a remote server "in {
		Given("A HttpClient")
		val httpClient:HttpClient = new HttpClient
		
		When("A HttpClient invoke a PUT REQUEST with JSON data for a URL at [httptest/put] resource, " +
		     "hosted in localhost and receive a response")
		val response:Response = httpClient.put("http://localhost:8080/httptest/put")
										  .data("{nome: 'Adriano Brito', cpf: '0382378'}")
										  .headers(Map("Content-Type" -> "application/json"))
										  .execute
		
		Then("The Response should have code 200")
		response.statusCode should be (200)
	}
	
	it should " invoke DELETE requests with params to a remote server "in {
		Given("A HttpClient")
		val httpClient:HttpClient = new HttpClient
		
		When("A HttpClient invoke a DELETE REQUEST with params for a URL at [httptest/delete] resource, " +
		     "hosted in localhost and receive a response")
		val response:Response = httpClient.delete("http://localhost:8080/httptest/delete")
										  .params(Map("usuario" -> "adrianos", "senha" -> "supertime"))
										  .execute
		
		Then("The Response should have code 200")
		response.statusCode should be (200)
	}
	
	it should " invoke GET requests to a remote server and format the response"in {
	  Given("A HttpClient")
	  val httpClient:HttpClient = new HttpClient
	  
	  When("The HttpClient invoke a GET REQUEST for a URL at [localhost/get] resource hosted in localhost " + 
			  "and receive a formatted response")
	  val response:Response = httpClient 
	  							.get("http://localhost:8080/httptest/get")
	  							.execute
	  val formattedResponse:String = response.format_to[String]((s:String) => s.reverse)
	  							
	  Then("The Response should have code 200 and the formatted response should be the reverse response content")
	  response.statusCode should be (200)
	  formattedResponse should be(response.toString.reverse)
	}
	
}
