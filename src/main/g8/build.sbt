
lazy val `$name$` = (project in file("."))
  .settings(
    libraryDependencies += "com.github.dnvriend" %% "sam-annotations" % "1.0.27",
    libraryDependencies += "com.github.dnvriend" %% "sam-lambda" % "1.0.27",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.2.0",
    libraryDependencies += "com.amazonaws" % "aws-java-sdk-dynamodb" % "1.11.255",
    libraryDependencies += "org.apache.avro" % "avro" % "1.8.2",
    resolvers += Resolver.bintrayRepo("dnvriend", "maven"),
    scalaVersion := "2.12.4",
	  samStage := "$stage$",
	  organization := "$organization$",
	  description := "sam's schema repository"
  )

  

