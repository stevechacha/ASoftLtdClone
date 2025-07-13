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
            baseName = "datastore"
            isStatic = true
        }
    }
    sourceSets {
        sourceSets {
            androidMain.dependencies {

            }
            commonMain.dependencies {
                implementation(libs.datastore)
                implementation(libs.datastore.preferences)
            }

            iosMain.dependencies {

            }
        }
    }
}