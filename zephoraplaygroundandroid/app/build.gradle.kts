plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id ("kotlin-parcelize")
    id("com.google.devtools.ksp")
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
    buildFeatures {
        viewBinding = true
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

    implementation(libs.loggingInterceptor)

    // Room
    implementation(libs.roomRuntime)
    implementation(libs.roomKtx)
    ksp(libs.roomCompiler)


    // DI
    implementation(libs.koinAndroid)

    // Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.junitAndroid)
    androidTestImplementation(libs.espresso)
}
