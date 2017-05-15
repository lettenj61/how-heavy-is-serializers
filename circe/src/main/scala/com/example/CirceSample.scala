package com.example

import scala.scalajs.js

import common._
import io.circe._, generic.semiauto._, syntax._

object CirceSample extends js.JSApp {

  implicit val fooEncoder = deriveEncoder[Foo]
  implicit val fooDecoder = deriveDecoder[Foo]
  implicit val barEncoder = deriveEncoder[Bar]
  implicit val barDecoder = deriveDecoder[Bar]

  def main(): Unit = {
    val j = Foo(age = 60).asJson
    println(j.noSpaces)

    val j2 = Map[String, Bar](
      "one" -> Bar.Bobx,
      "two" -> Bar.BaBomb(32L)
    )
    println(j2.asJson.noSpaces)
  }
}
