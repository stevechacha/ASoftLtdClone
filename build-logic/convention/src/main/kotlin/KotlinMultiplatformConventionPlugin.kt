import com.asoftltd.asoftltd.configureKotlinMultiplatform
import com.asoftltd.asoftltd.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager){
            apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("androidLibrary").get().get().pluginId)
            apply(libs.findPlugin("kotlin.serialization").get().get().pluginId)
            apply(libs.findPlugin("kotlin.parcelize").get().get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension>(::configureKotlinMultiplatform)
    }
}