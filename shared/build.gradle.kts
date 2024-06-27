import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.jetbrainsCompose)
    kotlin("plugin.serialization") version "1.9.23" // Kotlin Serialization 플러그인 추가
}

kotlin {
    androidTarget() //
    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            copy {
                from("$projectDir/shared/src/commonMain/resources")
                into("$buildDir/main")
            }
            commonWebpackConfig {
                cssSupport { enabled.set(true) }
                scssSupport { enabled.set(true) }
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).copy(
                    static = (devServer?.static ?: mutableListOf()).apply {
                        add(project.rootDir.path + "/shared/src/commonMain/resources")  // 정적 파일 경로 추가
                    },
                )
            }
            webpackTask {
                mainOutputFileName = "main.bundle.js"
            }
        }
    }

    js(IR) {
        browser {
            copy {
                from("$projectDir/shared/src/commonMain/resources")
                into("$buildDir/main")
            }
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).copy(
                    static = (devServer?.static ?: mutableListOf()).apply {
                        add(project.rootDir.path + "/shared/src/commonMain/resources")  // 정적 파일 경로 추가
                    },
                )
            }
            webpackTask {
                mainOutputFileName = "vocabulary_output.js"
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            api(libs.koin.core)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(libs.material3.window.size.multiplatform)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
        }
        val commonMain by getting {
            resources.srcDir("src/commonMain/resources")
        }

        val androidMain by getting
        val jsMain by getting {
            resources.srcDir("src/commonMain/resources")
        }
        val wasmJsMain by getting {
            resources.srcDir("src/commonMain/resources")
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}


android {
    namespace = "com.damda.vocabulary"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}

// android
tasks.register<Copy>("copyCommonResourcesToAndroidAssets") {
    from("src/commonMain/resources")
    into("src/androidMain/assets")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE // 또는 DuplicatesStrategy.EXCLUDE
}

tasks.getByName("preBuild").dependsOn("copyCommonResourcesToAndroidAssets")

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


afterEvaluate {
    project.tasks.getByName("jsProcessResources").finalizedBy(copyJsResources)
    project.tasks.getByName("wasmJsProcessResources").finalizedBy(copyWasmResources)

    // Declare explicit dependency
    project.tasks.getByName("jsJar").dependsOn(copyJsResources)
    project.tasks.getByName("wasmJsJar").dependsOn(copyWasmResources)
}
