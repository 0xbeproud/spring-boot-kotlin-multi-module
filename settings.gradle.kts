pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "hello-multi-modules"

include(":demo-core", ":demo-domain", ":demo-system", ":demo-app-api")
