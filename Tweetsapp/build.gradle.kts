plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // Hilt plugin
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}

// In case the Kotlin version is not defined, you can specify it explicitly here:
buildscript {
    val kotlin_version by extra("2.0.0") // Or the latest stable version

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}
