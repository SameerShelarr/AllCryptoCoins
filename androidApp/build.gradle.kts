plugins {
    id("com.android.application")
    kotlin("android")
}

val composeVersion = "1.2.0"
val koinVersion = "3.2.0"

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.sameershelar.allcryptocoins.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
}

dependencies {
    implementation(project(":shared"))

    // Main compose dependencies
    implementation ("androidx.compose.ui:ui:$composeVersion")
    implementation ("androidx.compose.material:material:$composeVersion")
    implementation ("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation ("androidx.activity:activity-compose:1.5.1")

    // Other compose dependencies
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha01")
    implementation ("androidx.navigation:navigation-compose:2.5.1")
    implementation ("com.google.accompanist:accompanist-flowlayout:0.17.0")

    // Koin DI
    implementation ("io.insert-koin:koin-android:$koinVersion")
    implementation ("io.insert-koin:koin-androidx-compose:$koinVersion")
}