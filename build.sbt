name := "akka-essentials"

version := "0.1"

scalaVersion := "2.13.6"

val akkaVersion = "2.6.16"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % "3.2.9"
)