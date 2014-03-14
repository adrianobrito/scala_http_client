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
  
  def get(url: String): Request = {
    new Request(url, "GET", timeout)
  }
  
  def post(url: String): Request = {
    new Request(url, "POST", timeout)
  }
  
  def put(url: String): Request = {
    new Request(url, "PUT", timeout)
  }
  
  def delete(url: String): Request = {
    new Request(url, "DELETE", timeout)
  }

}

