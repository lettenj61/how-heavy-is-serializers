package com.example

import scala.scalajs.js
import js.annotation._

import common._
import play.api.libs.json._

object PlayJsonSample extends js.JSApp {

  implicit val fooFormat = Json.format[Foo]
  implicit val barJsWrites = new Writes[Bar] {
    def writes(bar: Bar) = Json.obj(
      "millis" -> bar.millis
    )
  }

  def main(): Unit = {
    val j = Json.toJson(Foo(age = 60))
    println(Json.stringify(j))

    val j2 = Map(
      "one" -> Bar.Bobx,
      "two" -> Bar.BaBomb(32L)
    )
    println(Json.stringify(Json.toJson(j2)))
  }
}
