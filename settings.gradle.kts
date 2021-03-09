pluginManagement {
    repositories {
        gradlePluginPortal()
    }

    val pluginVersions = mapOf(
        "org.jetbrains.kotlin" to "1.3.71",
        "org.jetbrains.kotlin.plugin" to "1.3.71",
        "org.springframework" to "2.2.6.RELEASE",
        "io.spring" to "1.0.9.RELEASE"
    )
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace != null) {
                val namespace = requested.id.namespace
                if (pluginVersions.containsKey(namespace)) {
                    println("use plugins >>> ${namespace}:${pluginVersions[namespace]} ")
                    useVersion(pluginVersions[namespace])
                }
            }
        }
    }
}


rootProject.name = "hello-multi-modules"

include(":demo-core", ":demo-domain", ":demo-system", ":demo-app-api")
