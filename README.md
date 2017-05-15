# what is this
Comparing output JavaScript blob size of Scala.js project by JSON serialization lib its using.

## disclaimers
- No tests were provided.
- Sample code did not run, as it used just to run compilation process.

## the data

``` scala
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
```

## what this sample program do
- serialize given Scala object into JSON format, for each of
    - Scala case class `Foo()`.
    - Scala collection which has the case class as its value `Map[String, Bar]`.
- print its result string by `console.log()`

sample code for Circe:

``` scala
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
```

## result: serializing case class -> JSON

> for Scala.js linker version 0.6.16, scalac version 2.12.1

| lib       | version       | fastOptJS | fullOptJS |
| --------- | ------------- | --------- | --------- |
| circe     | 0.8.0         | 1,032 kb  | 231 kb    |
| play-json | 2.6.0 - M7    | 1,046 kb  | 235 kb    |
| upickle   | 0.4.4         | 1,151 kb  | 264 kb    |

## license
MIT license
