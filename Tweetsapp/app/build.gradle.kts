plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    //hilt and kapt
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.tweetsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.tweetsapp"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //for flowscope etc that we use in alignment
    implementation("androidx.compose.foundation:foundation:1.7.6")
    implementation("androidx.core:core-ktx:1.15.0")

    //hilt and kapt
    implementation("com.google.dagger:hilt-android:2.51.1") // Core Hilt dependency
    kapt("com.google.dagger:hilt-compiler:2.51.1") // KAPT compiler dependency for Hilt

    //viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

    // Core Kotlin Coroutines Dependency
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")

    // Retrofit Core Dependency
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    // Retrofit Converter for Gson (for JSON parsing)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Navigation Compose (if using Jetpack Compose)
    implementation("androidx.navigation:navigation-compose:2.8.5")
    //hilt with navigation
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //lottie animation
    implementation("com.airbnb.android:lottie-compose:6.6.2")

        //reflection
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.23")



}
// Allow references to generated code
kapt {
    correctErrorTypes =true
}