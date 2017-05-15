package com.example.common

case class Foo(name: String = "foo", age: Int)

sealed trait Bar {
  def millis: Long
}

object Bar {

  case object Bobx extends Bar {
    def millis: Long = 1L
  }

  final case class BaBomb(millis: Long) extends Bar
}
