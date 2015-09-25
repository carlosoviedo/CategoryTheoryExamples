val scalaTest =  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

lazy val root = (project in file(".")).
	settings(
        scalaVersion := "2.11.7",
		name := "CategoryTheoryExamples",
		libraryDependencies += scalaTest
	)
