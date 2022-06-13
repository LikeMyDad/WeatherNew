plugins {
    id("com.android.application")
    kotlin("plugin.serialization") version "1.5.30"
    kotlin("android")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
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

        buildConfigField("String", "weatherKey", "\"${getWeatherKey()}\"")
        buildConfigField("String", "citiesUrl", "\"${getCitiesUrl()}\"")
        buildConfigField("String", "weatherUrl", "\"${getWeatherUrl()}\"")
        buildConfigField("String", "weatherIconUrl", "\"${getWeatherIconUrl()}\"")

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

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        compose = true
    }
}

val androidList = listOf(
    Dependencies.Android.coreKtx,
    Dependencies.Android.appCompat,
    Dependencies.Android.material,
    Dependencies.Android.gson,
    Dependencies.Kotlin.serialization,
    Dependencies.Android.retrofit,
    Dependencies.Android.converter,
    Dependencies.Android.interceptor
)

val composeList = listOf(
    Dependencies.Compose.ui,
    Dependencies.Compose.material,
    Dependencies.Compose.tooling,
    Dependencies.Compose.livedata,
    Dependencies.Compose.accompanistUI,
    Dependencies.Compose.accompanist,
    Dependencies.Compose.navigationCompose,
    Dependencies.Compose.constraint,
    Dependencies.Compose.viewModel,
    Dependencies.Compose.paging
)

val lifeCycleList = listOf(
    Dependencies.Lifecycle.lifecycleKtx,
    Dependencies.Lifecycle.viewModelCompose,
    Dependencies.Lifecycle.activityCompose
)

val roomList = listOf(
    Dependencies.Room.ktx,
    Dependencies.Room.runtime,
    Dependencies.Room.paging
)

val koinList = listOf(
    Dependencies.Koin.koin,
    Dependencies.Koin.koinCompose,
    Dependencies.Koin.koinNavigation,
    Dependencies.Koin.compat
)

val coilList = listOf(
    Dependencies.Coil.coilCompose
)

dependencies {
    androidList.forEach { lib -> implementation(lib) }
    composeList.forEach { lib -> implementation(lib) }
    lifeCycleList.forEach { lib -> implementation(lib) }
    roomList.forEach { lib -> implementation(lib) }
    koinList.forEach { lib -> implementation(lib) }
    coilList.forEach { lib -> implementation(lib) }

    kapt(Dependencies.Room.compiler)

    testImplementation(Dependencies.Koin.test)
    testImplementation(Dependencies.Koin.testJunit)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidJUnit)
    androidTestImplementation(Dependencies.Test.espresso)

    androidTestImplementation(Dependencies.Compose.uiTest)
    debugImplementation(Dependencies.Compose.toolingTest)
}