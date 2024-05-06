plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.oguzhanozgokce.musicsplayer"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.oguzhanozgokce.musicsplayer"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //gson converter
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    // viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    // livedata
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    // recyclerview
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    // cardview
    implementation("androidx.cardview:cardview:1.0.0")
    //room
    implementation("androidx.room:room-runtime:2.3.0")






}