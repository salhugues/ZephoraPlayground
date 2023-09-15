plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.salhugues.zephoraplayground"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.salhugues.zephoraplayground"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.coreKtx)
    implementation(libs.appCompat)
    implementation(libs.material)
    implementation(libs.constraintLayout)
    implementation(libs.kotlinxSerializationJson)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofitConverter)

    // DI
    implementation(libs.koinAndroid)

    // Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.junitAndroid)
    androidTestImplementation(libs.espresso)
}
