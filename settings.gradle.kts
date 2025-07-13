rootProject.name = "ASoftLtdClone"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":feature:auth")
include(":feature:home")
include(":feature:more")
include(":feature:finance")
include(":feature:academics")
include(":feature:admissions")


include(":core:ui")
include(":core:designsystem")
include(":core:domain")
include(":core:data")
include(":core:database")
include(":core:network")
include(":core:common")
include(":core:datastore")