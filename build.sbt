lazy val hsl = crossProject(JSPlatform, JVMPlatform/*, NativePlatform*/).in(file(".")).
  settings(
    name := "hsl",
    version := "1.0.0",
    scalaVersion := "2.13.4",
    scalacOptions ++=
      Seq(
        "-deprecation", "-feature", "-unchecked",
        "-language:postfixOps", "-language:implicitConversions", "-language:existentials", "-language:dynamics",
        "-Xasync"
      ),
    organization := "xyz.hyperreal",
    mainClass := Some("xyz.hyperreal.hsl.Main"),
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.3" % "test",
    publishMavenStyle := true,
    publishArtifact in Test := false,
    licenses := Seq("ISC" -> url("https://opensource.org/licenses/ISC"))
  ).
  jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % "1.0.0" % "provided",
  ).
//  nativeSettings(
//    libraryDependencies ++=
//      Seq(
//        "com.lihaoyi" %%% "utest" % "0.7.7" % "test",
//      ),
//  ).
  jsSettings(
    jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv(),
//    Test / scalaJSUseMainModuleInitializer := true,
//    Test / scalaJSUseTestModuleInitializer := false,
    Test / scalaJSUseMainModuleInitializer := false,
    Test / scalaJSUseTestModuleInitializer := true,
    scalaJSUseMainModuleInitializer := true,
  )
