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
            baseName = "admissions"
            isStatic = true
        }
    }
    sourceSets {
        androidMain.dependencies {

        }
        commonMain.dependencies {
            api(libs.compose.image.loader)
            implementation(projects.core.ui)
            implementation(projects.core.designsystem)
            implementation(projects.core.domain)
            implementation(projects.core.data)
            implementation(projects.core.database)
            implementation(projects.core.network)
            implementation(projects.core.common)
            implementation(projects.core.datastore)
            implementation(libs.bundles.koin)
        }

        iosMain.dependencies {

        }
    }
}