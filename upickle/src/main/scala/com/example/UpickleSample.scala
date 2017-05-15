package com.example

import scala.scalajs.js

import common._

object UpickleSample extends js.JSApp {

  def main(): Unit = {
    val j = upickle.default.write(Foo(age = 60))
    println(j)

    val j2 = Map[String, Bar](
      "one" -> Bar.Bobx,
      "two" -> Bar.BaBomb(32L)
    )
    println(upickle.default.write(j2))
  }
}
