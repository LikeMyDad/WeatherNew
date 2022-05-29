object Dependencies {

    object Compose {
        const val version = "1.0.5"
        const val companist = "0.24.9-beta"

        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material:material:$version"
        const val tooling = "androidx.compose.ui:ui-tooling-preview:$version"
        const val livedata = "androidx.compose.runtime:runtime-livedata:$version"

        const val toolingTest = "androidx.compose.ui:ui-tooling:$version"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"

        const val activity = "androidx.activity:activity-compose:1.3.1"
        const val viewModels = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"

        const val accompanistUI = "com.google.accompanist:accompanist-systemuicontroller:$companist"
        const val accompanist = "com.google.accompanist:accompanist-permissions:$companist"

        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.2"
    }

    object Kotlin {
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2"
    }

    object Coil {
        private const val version = "2.1.0"
        const val coilCompose = "io.coil-kt:coil-compose:$version"
    }

    object Koin {
        private const val version= "3.2.0"
        const val koin = "io.insert-koin:koin-android:$version"
        const val koinNavigation = "io.insert-koin:koin-androidx-navigation:$version"
        const val koinCompose = "io.insert-koin:koin-androidx-compose:$version"
        const val testJunit = "io.insert-koin:koin-test-junit4:$version"
        const val test = "io.insert-koin:koin-test:$version"
        const val compat = "io.insert-koin:koin-android-compat:$version"
    }

    object Room {
        private const val version = "2.4.2"
        const val ktx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val paging = "androidx.room:room-paging:$version"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Android {
        private const val version_retrofit = "2.9.0"

        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"
        const val gson = "com.google.code.gson:gson:2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version_retrofit"
        const val converter = "com.squareup.retrofit2:converter-gson:$version_retrofit"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:4.9.3"
    }

    object Lifecycle {
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
        const val activityCompose = "androidx.activity:activity-compose:1.3.1"
    }

    object Test {
        const val jUnit = "junit:junit:4.+"
        const val androidJUnit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }

}