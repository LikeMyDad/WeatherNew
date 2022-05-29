pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.0.2")
            }
            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.5.31")
            }
        }
    }
}
rootProject.name = "Weather New"
include(":app")
