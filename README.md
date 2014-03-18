scala_http_client
=================

A Http client for Scala Apps. It could be used on Service Oriented Applications. It make simple to call any URL with a HTTP method, supporting only the four HTTP basic methods: GET, POST, PUT, DELETE. 

### Use

Invoking GET requests on a specified URL:

    val response:Response = new HttpClient().get("http://url.com/json")
                                            .execute;
    println(response)

Invoking GET requests on specified URL with params:

    val response:Response = new HttpClient().get("http://url.com/json")
                                            .params(Map("nome" -> "Adriano Brito"))
                                            .execute;
    println(response)

Invoking POST requests on specified URL with Headers and sending Data:

    val response:Response = new HttpClient().post("http://localhost:8080/httptest/post")
                                            .data("{nome: 'Adriano Brito', cpf: '0382378'}")
                                            .headers(Map("Content-Type" -> "application/json"))
                                            .execute

### Add to your Project

It`s not deployed to Maven Central Repository. You will can download it soon.
