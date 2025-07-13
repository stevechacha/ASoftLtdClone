plugins {
    alias(libs.plugins.module.kotlinMultiplatform)
    alias(libs.plugins.module.composeMultiplatform)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "common"
            isStatic = true
        }
    }
    sourceSets {
        androidMain.dependencies {

        }
        commonMain.dependencies {
            implementation(libs.compose.image.loader)
            implementation(projects.core.domain)
        }

        iosMain.dependencies {

        }
    }
}