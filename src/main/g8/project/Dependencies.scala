import sbt.Keys._
import sbt._

object Dependencies {
  object Versions {
    val scalatest = "3.0.0"
  }
  val test = Seq(
    libraryDependencies += "org.scalatest" %% "scalatest" % Versions.scalatest % "test"
  )

  val commonSettings = Seq(
    scalaVersion in ThisBuild := "2.11.8",
    resolvers ++= Seq(
      Resolver.sonatypeRepo("releases"),
      Resolver.sonatypeRepo("snapshots"),
      Resolver.bintrayRepo("scalaz", "releases")
    ),
    addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")
  )

  val settings = commonSettings ++ test
  

}
