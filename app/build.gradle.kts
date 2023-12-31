plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.newscompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newscompose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifeCycleRunTimeKtx)
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.activityBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphic)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeMaterial3)

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltAndroidCompiler)
    implementation(Dependencies.hiltNavigationCompose)

    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConvertor)
    implementation(Dependencies.moshiKotlin)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.loggingInterceptor)
    implementation(Dependencies.coroutineCore)
    implementation(Dependencies.coroutineAndroid)
    implementation(Dependencies.splashScreen)
    implementation(Dependencies.coil)





    implementation(project(Modules.utilities))
}
kapt{
    correctErrorTypes = true
}