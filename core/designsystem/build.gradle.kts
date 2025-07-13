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
            baseName = "designsystem"
            isStatic = true
        }
    }
    sourceSets {
        sourceSets {
            androidMain.dependencies {

            }
            commonMain.dependencies {
                api(libs.compose.image.loader)
                implementation(projects.core.domain)
                implementation(projects.core.common)
            }

            iosMain.dependencies {

            }
        }
    }
}


compose.resources {
    publicResClass = true
    packageOfResClass = "com.asoftltd.asoftltd.designsystem"
    generateResClass = auto
}