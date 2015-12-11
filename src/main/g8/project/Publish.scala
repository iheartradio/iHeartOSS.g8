import sbt._, Keys._
import bintray.BintrayKeys._


object Publish {

  val bintraySettings = Seq(
    bintrayOrganization := Some("$organization$"),
    bintrayPackageLabels := Seq("$name$")
  )

  val publishingSettings = Seq(
    organization in ThisBuild := "$rootpackage$",
    publishMavenStyle := true,
    licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html")),
    homepage := Some(url("http://$organization$.github.io/$name;format=normalize$")),
    scmInfo := Some(ScmInfo(url("https://github.com/$organization$/$name;format=normalize$"),
      "git@github.com:$organization$/$name;format=normalize$.git")),
    pomIncludeRepository := { _ => false },
    publishArtifact in Test := false
  )

  val settings = bintraySettings ++ publishingSettings
}
