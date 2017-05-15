# what is this
Comparing output JavaScript blob size of Scala.js project by JSON serialization lib its using.

## disclaimers
- No tests were provided.
- Sample code did not run, as it used just to run compilation process.

## result: serializing case class -> JSON

> for Scala.js linker version 0.6.16, scalac version 2.12.1

| lib       | version       | fastOptJS | fullOptJS |
| --------- | ------------- | --------- | --------- |
| circe     | 0.8.0         | 1,032 kb  | 231 kb    |
| play-json | 2.6.0 - M7    | 1,046 kb  | 235 kb    |
| upickle   | 0.4.4         | 1,151 kb  | 264 kb    |

## license
MIT license
