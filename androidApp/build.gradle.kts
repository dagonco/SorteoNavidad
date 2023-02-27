plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "io.github.dagonco.sorteo"
    compileSdk = 33
    defaultConfig {
        applicationId = "io.github.dagonco.sorteo"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(platform("androidx.compose:compose-bom:2023.01.00"))

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.material3:material3")

    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.navigation:navigation-compose:2.5.3")

    implementation("io.insert-koin:koin-core:3.3.3")
    implementation("io.insert-koin:koin-android:3.3.3")
    implementation("io.insert-koin:koin-androidx-compose:3.4.2")


    implementation("io.ktor:ktor-client-okhttp:2.2.2")
    implementation("dev.icerock.moko:mvvm-flow-compose:0.15.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    implementation(kotlin("test-junit"))
    implementation("io.mockk:mockk-android:1.12.5")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
}