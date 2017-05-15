val commonSettings = List(
  organization := "com.example",
  scalaVersion := "2.12.1",
  version      := "0.1.0-SNAPSHOT",
  scalacOptions in Compile ++= Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-unchecked",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Ywarn-unused-import",
    "-Ywarn-unused"
  )
)

lazy val common = crossProject.in(file("common"))
  .settings(commonSettings: _*)

lazy val commonJs = common.js

lazy val playJson = project.in(file("play-json"))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(commonJs)
  .settings(commonSettings: _*)
  .settings(
    name := "play-json-sample",
    libraryDependencies ++= Seq(
      "com.typesafe.play" %%% "play-json" % "2.6.0-M7"
    )
  )

lazy val circe = project.in(file("circe"))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(commonJs)
  .settings(commonSettings: _*)
  .settings(
    name := "circe-sample",
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-core" % "0.8.0",
      "io.circe" %%% "circe-generic" % "0.8.0",
      "io.circe" %%% "circe-parser" % "0.8.0"
    )
  )

lazy val uPickle = project.in(file("upickle"))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(commonJs)
  .settings(commonSettings: _*)
  .settings(
    name := "upickle-sample",
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "upickle" % "0.4.4"
    )
  )
