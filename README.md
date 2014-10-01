scala_http_client
=================

A Http client for Scala Apps. It could be used on Service Oriented Applications. It make simple to call any URL with a HTTP method, supporting only the four HTTP basic methods: GET, POST, PUT, DELETE. 

### Use

Invoking GET requests on a specified URL:
```scala
    val response:Response = new HttpClient().get("http://url.com/json")
                                            .execute;
    println(response)
```

Invoking GET requests on specified URL with params:
```scala
    val response:Response = new HttpClient().get("http://url.com/json")
                                            .params(Map("nome" -> "Adriano Brito"))
                                            .execute;
    println(response)
```
Invoking POST requests on specified URL with Headers and sending Data:
```scala
    val response:Response = new HttpClient().post("http://url.com/json")
                                            .data("{nome: 'Adriano Brito', cpf: '0382378'}")
                                            .headers(Map("Content-Type" -> "application/json"))
                                            .execute
```
Invoking GET requests on specified URL with reversed Response Content:
```scala
    val response:Response = new HttpClient().get("http://url.com/json")
                                            .execute;
    val formattedResponse:String = response.format_to[String]((s:String) => s.reverse)
```

You could format the response to any Class. You could use this feature to format JSON or XML Requests to any Class, integrated with libraries like [json4s](https://github.com/json4s/json4s) or [Jackson](https://github.com/FasterXML/jackson-module-scala), like the example below:
```scala
    val formattedResponse:String = response.format_to[Person]((s:String) => service.deserialize[T](s));
```
### Tests

You will need a [scalawebtemplate](https://github.com/adrianobrito/scalawebtemplate) project to execute the tests. 

### Add to your Project

It`s not deployed to Maven Central Repository. You will can download it soon.
