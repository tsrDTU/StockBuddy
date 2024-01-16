plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // https://github.com/raamcosta/compose-destinations/blob/main/README.md
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" // Depends on your kotlin version
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")

}


android {
    namespace = "com.stockbuddy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.stockbuddy"
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}

dependencies {
    implementation ("androidx.compose.ui:ui:1.5.4")
    implementation ("androidx.compose.material:material:1.5.4")
    implementation ("androidx.compose.ui:ui-tooling:1.5.4")
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))
 //   val composeBom = platform("androidx.compose:compose-bom:2023.10.01")
 //   implementation(composeBom)

    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")

    implementation("com.google.firebase:firebase-analytics")

    implementation("com.google.dagger:hilt-android:2.48.1")
    implementation("com.google.firebase:firebase-firestore:24.10.0")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    implementation("androidx.room:room-common:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // retrofit

    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // Parsing Json files
    implementation("com.google.code.gson:gson:2.8.6")

    // coroutine

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    // OpenCSV
    implementation("com.opencsv:opencsv:5.8")

    // Singleton and dependency injection

    implementation("javax.inject:javax.inject:1")

    implementation ("com.google.dagger:hilt-android:2.48.1")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.48.1")

    // For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.48.1")
    androidTestAnnotationProcessor ("com.google.dagger:hilt-compiler:2.48.1")

    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:2.48.1")
    testAnnotationProcessor ("com.google.dagger:hilt-compiler:2.48.1")
    val composeBom = platform("androidx.compose:compose-bom:2023.10.01")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Choose one of the following:
    // Material Design 3
    implementation("androidx.compose.material3:material3")

    /*
    // or Material Design 2
    implementation("androidx.compose.material:material")
    // or skip Material Design and build directly on top of foundational components
    implementation("androidx.compose.foundation:foundation")
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation("androidx.compose.ui:ui")

     */

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Optional - Included automatically by material, only add when you need
    // the icons but not the material library (e.g. when using Material3 or a
    // custom design system based on Foundation)
    implementation("androidx.compose.material:material-icons-core")
    // Optional - Add full set of material icons
    implementation("androidx.compose.material:material-icons-extended")
    // Optional - Add window size utils
    implementation("androidx.compose.material3:material3-window-size-class")

    // Optional - Integration with activities
    implementation("androidx.activity:activity-compose:1.8.0")
    // Optional - Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    // Optional - Integration with LiveData
    implementation("androidx.compose.runtime:runtime-livedata")
    // Optional - Integration with RxJava
    implementation("androidx.compose.runtime:runtime-rxjava2")

    // For further info check out: https://github.com/raamcosta/compose-destinations/blob/main/README.md
    implementation("io.github.raamcosta.compose-destinations:core:1.9.54")

    //moshi
    implementation ("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation ("com.squareup.moshi:moshi:1.14.0")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    // OkHttp for network requests
    implementation("com.squareup.okhttp3:okhttp:4.9.0")

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

}

kapt {
    correctErrorTypes = true
}

