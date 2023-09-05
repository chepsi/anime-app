plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.junit5)
}

android {
    namespace = "chepsi.anime.app.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":datasource:local"))
    implementation(project(":datasource:remote"))
    implementation(project(":domain"))

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.core.ktx)

    implementation(libs.timber)

    testImplementation(libs.junit.jupiter.api)
    testImplementation(project(":datasource:remote"))
    testRuntimeOnly(libs.junit.jupiter.engine)
    testImplementation(libs.junit.jupiter.params)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)
}
