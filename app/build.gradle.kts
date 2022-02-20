plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.5.30"
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSDK
        targetSdk = Config.targetSDK
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "weatherUrl", "\"${getWeatherKey()}\"")
        buildConfigField("String", "citiesUrl", "\"${getCitiesUrl()}\"")
        buildConfigField("String", "weatherKey", "\"${getWeatherUrl()}\"")

    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.material)

    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.livedata)
    implementation(Dependencies.Compose.accompanist)

    implementation(Dependencies.Lifecycle.lifecycleKtx)
    implementation(Dependencies.Lifecycle.viewModelCompose)
    implementation(Dependencies.Lifecycle.activityCompose)
    implementation(Dependencies.Navigation.navigationCompose)

    implementation(Dependencies.Kotlin.serialization)

    // Hilt
    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Hilt.navigation)
    kapt(Dependencies.Hilt.compiler)

    // Room
    implementation(Dependencies.Room.ktx)
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.paging)
    kapt(Dependencies.Room.compiler)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidJUnit)
    androidTestImplementation(Dependencies.Test.espresso)

    androidTestImplementation(Dependencies.Compose.uiTest)
    debugImplementation(Dependencies.Compose.toolingTest)
}