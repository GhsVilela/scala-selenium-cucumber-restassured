ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scala-selenium-cucumber-restassured"
  )

libraryDependencies += "io.cucumber" % "cucumber-junit" % "7.3.3"
libraryDependencies += "io.cucumber" %% "cucumber-scala" % "8.3.2"
libraryDependencies += "org.scalatestplus" %% "selenium-3-141" % "3.2.10.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12"
libraryDependencies += "io.github.bonigarcia" % "webdrivermanager" % "5.1.1"
libraryDependencies += "io.rest-assured" % "scala-support" % "5.0.1"
libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3"
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.36"
