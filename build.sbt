organization := "com.github.kmizu"

name := "tropical"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.7"

scalacOptions <++= scalaVersion map { v =>
  Seq("-unchecked", "-deprecation", "-feature", "-language:implicitConversions")
}

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3",
  "junit" % "junit" % "4.7" % "test",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test"
)

initialCommands in console += {
  Iterator("com.github.kmizu.tropical._", "MinPlus._").map("import "+).mkString("\n")
}
