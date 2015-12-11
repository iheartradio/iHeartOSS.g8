import sbt._
import Keys._

object Projects extends Build {
  lazy val $name;format="camel"$ = project.in(file("."))
    .settings(moduleName := "root")
    .aggregate(core, test)
    .settings(Common.settings:_*)
    .settings(Common.noPublishing: _*)

  lazy val core = project.in(file("core"))
    .settings(moduleName := "$name;format="normalize"$-core")
    .settings(Common.settings:_*)
    .settings(Dependencies.settings:_*)
    .settings(Publish.settings:_*)
    .settings(Format.settings:_*)

  lazy val test = project.in(file("test"))
    .dependsOn(core % "compile->compile;test->test")
    .settings(moduleName := "$name;format="normalize"$-tests")
    .settings(Common.settings:_*)
    .settings(Common.noPublishing: _*)
    .settings(Dependencies.testSettings:_*)
    .settings(Format.settings:_*)
    .settings(Testing.settings:_*)

  lazy val examples = project.in(file("example"))
    .dependsOn(core % "compile->compile;test->test")
    .settings(moduleName := "$name;format="normalize"$-examples")
    .settings(Common.settings:_*)
    .settings(Common.noPublishing: _*)
    .settings(Format.settings:_*)




}
