import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import com.android.build.api.dsl.LibraryExtension
import com.asoftltd.asoftltd.configureKotlinAndroid
import com.asoftltd.asoftltd.libs


class ComposeMultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.findPlugin("composeMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("compose.compiler").get().get().pluginId)
        }

        val composeDeps = extensions.getByType<ComposeExtension>().dependencies

        extensions.configure<LibraryExtension>(::configureKotlinAndroid)

        extensions.configure<KotlinMultiplatformExtension> {

            sourceSets.apply {

                commonTest {
                    dependencies {
                        implementation(kotlin("test"))
                        implementation(kotlin("test-common"))
                        implementation(kotlin("test-annotations-common"))
                        implementation(libs.findLibrary("kotest.framework.engine").get())
                        implementation(libs.findLibrary("kotest.assertions.core").get())
                        implementation(libs.findLibrary("kotest.property").get())
                        implementation(libs.findLibrary("ktor.mock").get())
                        implementation(libs.findLibrary("coroutines.test").get())
                        implementation(libs.findLibrary("turbine.turbine").get())
                        implementation(libs.findLibrary("mockk.io").get())
                        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                        implementation(composeDeps.uiTest)
                    }
                }


                commonMain {
                    dependencies {
                        implementation(composeDeps.runtime)
                        implementation(composeDeps.foundation)
                        implementation(composeDeps.animation)
                        implementation(composeDeps.material3)
                        implementation(composeDeps.material)
                        implementation(composeDeps.ui)
                        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                        implementation(composeDeps.components.resources)
                        api(composeDeps.materialIconsExtended)
                        implementation(composeDeps.components.uiToolingPreview)
                        implementation(libs.findLibrary("ktor.client.core").get())
                        implementation(libs.findLibrary("ktor.client.logging").get())
                        implementation(libs.findLibrary("ktor.client.serialization").get())
                        implementation(libs.findLibrary("ktor.client.content.negotiation").get())
                        implementation(libs.findLibrary("kotlinx.serialization.json").get())
                        implementation(libs.findLibrary("kotlinx.datetime").get())
                        implementation(libs.findLibrary("kotlinx.coroutines.core").get())
                        implementation(libs.findLibrary("compose.navigation").get())
                        implementation(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                        api(libs.findLibrary("koin.core").get())
                        api(libs.findLibrary("koin.compose").get())
                        api(libs.findLibrary("coil3").get())
                        api(libs.findLibrary("coil3.network").get())
                    }
                }

                androidMain {
                    dependencies {
                        api(libs.findLibrary("androidx.activity.compose").get())
                        api(libs.findLibrary("androidx.appcompat").get())
                        api(libs.findLibrary("androidx.core.ktx").get())
                        implementation(composeDeps.preview)
                        implementation(libs.findLibrary("koin.android").get())
                        implementation(libs.findLibrary("ktor.client.okhttp").get())
                        api(libs.findLibrary("coil3.gif").get())
                        api(libs.findLibrary("coil3.svg").get())
                        api(libs.findLibrary("coil3.core").get())
                    }
                }

                iosMain {
                    dependencies {
                        implementation(libs.findLibrary("ktor.client.darwin").get())
                        implementation(libs.findLibrary("ktor.ios").get())
                    }
                }
            }
        }
    }
}