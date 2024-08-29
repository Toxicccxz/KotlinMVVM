plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.android)
    id("kotlin-parcelize")
}

android {
    namespace = "com.xavier.kotlinmvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.xavier.kotlinmvvm"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    flavorDimensions += "default"
    productFlavors {
        create("dev") {
            dimension = "default"
            applicationIdSuffix = ".dev"
        }
        create("prod") {
            dimension = "default"
        }
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

configurations.all {
    resolutionStrategy {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-debug")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //kotlin
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
    implementation(libs.androidx.annotation)
    implementation(libs.picasso)
    implementation(libs.lifecycle.livedata.ktx)
    androidTestImplementation(libs.androidx.junit.ktx)

    //retrofit
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.moshi)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.glide) {
        exclude(group = "com.android.support")
    }
    implementation(libs.activity.ktx)

    //Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.lifecycle.viewmodel)
    kapt(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)

    //junit 5
    testImplementation(libs.junit.jupiter.engine)
    testImplementation(libs.mockk)
    androidTestImplementation(libs.assertj.core)
    androidTestImplementation(libs.espresso.intents)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.core.testing)
    implementation(libs.espresso.idling.resource)
    implementation(libs.espresso.contrib)
}