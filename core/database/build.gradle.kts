plugins {
    alias(libs.plugins.module.kotlinMultiplatform)
    alias(libs.plugins.module.composeMultiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)

}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "database"
            isStatic = true
        }
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }

    sourceSets {
        androidMain.dependencies {

        }
        commonMain.dependencies {
            implementation(libs.androidx.room.runtime)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.sqlite.bundled)
        }

        iosMain.dependencies {

        }
    }
}