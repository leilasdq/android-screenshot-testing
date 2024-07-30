plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.screenshot)
    id("io.github.takahirom.roborazzi")
}

android {
    namespace = "com.example.screenshottestingsample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.screenshottestingsample"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    testOptions.unitTests.isIncludeAndroidResources = true
    experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // screenshot testing
    screenshotTestImplementation(libs.androidx.compose.ui.tooling)

    // roborazzi
    testImplementation("androidx.compose.ui:ui-test-junit4-android")
    testImplementation("org.robolectric:robolectric:4.10.3")
    testImplementation("io.github.takahirom.roborazzi:roborazzi:1.7.0-alpha-1")
    testImplementation("io.github.takahirom.roborazzi:roborazzi-compose:1.7.0-alpha-1")
    testImplementation("androidx.test.ext:junit-ktx:1.1.5")
}