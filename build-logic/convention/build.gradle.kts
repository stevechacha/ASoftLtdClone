plugins {
    `kotlin-dsl`
}

group = "com.asoftltd.asoftltd.buildlogic"

dependencies {
    compileOnly(libs.plugins.kotlin.serialization.toDep())
    compileOnly(libs.plugins.androidApplication.toDep())
    compileOnly(libs.plugins.androidLibrary.toDep())
    compileOnly(libs.plugins.composeMultiplatform.toDep())
    compileOnly(libs.plugins.kotlinMultiplatform.toDep())
    compileOnly(libs.plugins.compose.compiler.toDep())
}

fun Provider<PluginDependency>.toDep() = map {
    "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}"
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("kotlinMultiplatform") {
            id = "com.asoftltd.asoftltd.kotlinMultiplatform"
            implementationClass = "KotlinMultiplatformConventionPlugin"
        }
        register("composeMultiplatform") {
            id = "com.asoftltd.asoftltd.composeMultiplatform"
            implementationClass = "ComposeMultiplatformConventionPlugin"
        }
        register("androidApp") {
            id = "com.asoftltd.asoftltd.androidApp"
            implementationClass = "AndroidAppConventionPlugin"
        }
    }
}
