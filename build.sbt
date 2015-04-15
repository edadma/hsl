name := "HSL"

version := "0.1"

scalaVersion := "2.11.6"

scalacOptions ++= Seq( "-deprecation", "-feature", "-language:postfixOps", "-language:implicitConversions", "-language:existentials" )

incOptions := incOptions.value.withNameHashing( true )

organization := "ca.hyperreal"

//resolvers += Resolver.sonatypeRepo( "snapshots" )

resolvers += "Hyperreal Repository" at "http://hyperreal.ca/maven2"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.3" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.11.5" % "test"

libraryDependencies ++= Seq(
	"org.scala-lang.modules" %% "scala-swing" % "1.0.1"
//	"org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.2"
	)

mainClass in (Compile, run) := Some( "ca.hyperreal.hsl.Main" )

//offline := true


seq(bintraySettings:_*)

publishMavenStyle := true

//publishTo := Some( Resolver.sftp( "private", "hyperreal.ca", "/var/www/hyperreal.ca/maven2" ) )

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))

homepage := Some(url("https://github.com/edadma/hsl"))

pomExtra := (
  <scm>
    <url>git@github.com:edadma/hsl.git</url>
    <connection>scm:git:git@github.com:edadma/hsl.git</connection>
  </scm>
  <developers>
    <developer>
      <id>edadma</id>
      <name>Edward A. Maxedon, Sr.</name>
      <url>http://hyperreal.ca</url>
    </developer>
  </developers>)
