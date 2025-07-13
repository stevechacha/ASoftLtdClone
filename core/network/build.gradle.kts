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
            baseName = "network"
            isStatic = true
        }
    }
    sourceSets {
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)

        }
        commonMain.dependencies {
            implementation(projects.core.domain)
            implementation(libs.kotlinx.serialization.json)
            api(libs.ktor.client.core)
            api(libs.ktor.client.content.negotiation)
            api(libs.bundles.ktor.common)
            implementation(project.dependencies.platform(libs.superbase.bom))
            implementation(libs.bundles.supabase)


        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)

        }
    }
}