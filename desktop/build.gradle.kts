plugins {
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.jetbrainsKotlinJvm)
}

compose.desktop {
    application {
        mainClass = "Main"
        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Rpm
            )
        }
    }

    dependencies {
        implementation(projects.shared)
        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.material)
        implementation(compose.material3)
        implementation(compose.desktop.currentOs)

    }

}