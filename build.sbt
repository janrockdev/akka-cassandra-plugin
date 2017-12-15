name := "akka-cassandra-plugin"

version := "1.0.6"

scalaVersion := "2.11.8"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

scalacOptions += "-deprecation"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.4.17"
libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % "3.0.0"
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.8"
libraryDependencies += "org.apache.logging.log4j" % "log4j-1.2-api" % "2.8"
libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.8"
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.5"
        