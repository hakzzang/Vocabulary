import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.jetbrainsCompose)
}

group = "com.hbs"

kotlin {
    js(IR) {
        moduleName = "webApp"
        browser {
            copy {
                from("$projectDir/shared/src/commonMain/resources")
                into("$buildDir/processedResources/js/main")
            }
            commonWebpackConfig {
                outputFileName = "vocabulary_output.js"
            }
            webpackTask {
                mainOutputFileName = "vocabulary_output.js"
            }
            binaries.executable()
        }
    }
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "webApp"
        browser {
            copy {
                from("$projectDir/shared/src/commonMain/resources")
                into("$buildDir/processedResources/wasmJs/main")
            }
            commonWebpackConfig {
                outputFileName = "vocabulary_output.js"
            }
            binaries.executable()
        }
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                resources.srcDir("src/commonMain/resources")
                implementation(projects.shared)

                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(compose.html.core)
                implementation(compose.web.core)
            }
        }
        val wasmJsMain by getting {
            dependencies {
                resources.srcDir("src/commonMain/resources")
                implementation(projects.shared)

                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }
    }
}
compose.experimental {
    web.application {}
}

// web
tasks.withType<ProcessResources> {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

val copyJsResources = tasks.create("copyJsResourcesWorkaround", Copy::class.java) {
    from(project(":shared").file("src/commonMain/resources"))
    into("build/processedResources/js/main")
}

val copyWasmResources = tasks.create("copyWasmResourcesWorkaround", Copy::class.java) {
    from(project(":shared").file("src/commonMain/resources"))
    into(file("build/processedResources/wasmJs/main"))
}

tasks.named("wasmJsJar") {
    dependsOn(copyWasmResources)
}

tasks.named("jsJar") {
    dependsOn(copyJsResources)
}
