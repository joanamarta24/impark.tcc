@file:Suppress("UNREACHABLE_CODE")

import org.gradle.kotlin.dsl.implementation


// Configurações de proxy
System.setProperty("http.proxyHost", "proxy.company.com")
System.setProperty("http.proxyPort", "443")
System.setProperty("http.proxyUser", "userid")
System.setProperty("http.proxyPassword", "password")
System.setProperty("http.auth.ntlm.domain", "domain")

System.setProperty("https.proxyHost", "proxy.company.com")
System.setProperty("https.proxyPort", "443")
System.setProperty("https.proxyUser", "userid")
System.setProperty("https.proxyPassword", "password")
System.setProperty("https.auth.ntlm.domain", "domain")

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.imparktcc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.imparktcc"
        minSdk = 21
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.48")

    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    implementation(platform("androidx.compose:compose-bom:2024.04.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation("androidx.navigation:navigation-compose:2.8.3")
    implementation("androidx.compose.animation:animation")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.04.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
