 lazy val $name;format="camel"$ = project.in(file("."))
    .settings(moduleName := "root")
    .aggregate(core)
    .settings(Common.settings:_*)
    .settings(Common.noPublishing: _*)

lazy val core = project.in(file("core"))
    .settings(moduleName := "$name;format="normalize"$-core")
    .settings(Common.settings:_*)
    .settings(Dependencies.settings:_*)
    .settings(Publish.settings:_*)
    .settings(Format.settings:_*)


lazy val examples = project.in(file("examples"))
    .dependsOn(core)
    .aggregate(core)
    .settings(moduleName := "$name;format="normalize"$-examples")
    .settings(Common.settings:_*)
    .settings(Common.noPublishing: _*)
    .settings(Format.settings:_*)

