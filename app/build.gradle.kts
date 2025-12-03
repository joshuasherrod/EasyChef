import java.util.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(FileInputStream(localPropertiesFile))
}

android {
    namespace = "com.example.easychef"
    compileSdk = 36
    buildToolsVersion = "36.0.0"

    defaultConfig {
        applicationId = "com.example.easychef"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.easychef.HiltTestRunner"

        vectorDrawables.useSupportLibrary = true

        buildConfigField(
            "String",
            "SUPABASE_URL",
            "\"${localProperties.getProperty("SUPABASE_URL") ?: ""}\""
        )
        buildConfigField(
            "String",
            "SUPABASE_ANON_KEY",
            "\"${localProperties.getProperty("SUPABASE_ANON_KEY") ?: ""}\""
        )
        buildConfigField(
            "String",
            "SPOONACULAR_API_KEY",
            "\"${project.findProperty("SPOONACULAR_API_KEY") ?: ""}\""
        )
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs += listOf("-Xmetadata-version=2.1.0")
    }

    buildFeatures {
        compose = true
        buildConfig = true
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

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
        // --- AndroidX / Compose ---
        implementation(platform("androidx.compose:compose-bom:2024.06.00"))
        implementation("androidx.activity:activity-compose:1.9.3")
        implementation("androidx.compose.material3:material3")
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-tooling-preview")
        debugImplementation("androidx.compose.ui:ui-tooling")

        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
        implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")

        // --- Supabase (built for Kotlin 2.0.x) ---
        implementation(platform("io.github.jan-tennert.supabase:bom:3.0.3"))
        implementation("io.github.jan-tennert.supabase:auth-kt")
        implementation("io.github.jan-tennert.supabase:postgrest-kt")

        // --- Ktor (3.2.x is last with Kotlin 2.0.x) ---
        implementation(platform("io.ktor:ktor-bom:3.2.1"))
        implementation("io.ktor:ktor-client-core")
        implementation("io.ktor:ktor-client-okhttp")
        implementation("io.ktor:ktor-client-content-negotiation")
        implementation("io.ktor:ktor-serialization-kotlinx-json")

        // --- Serialization + Coroutines (for Kotlin 2.0.x) ---
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")

        // --- OkHttp / Retrofit ---
        implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
        implementation("com.squareup.okhttp3:okhttp")
        implementation("com.squareup.okhttp3:logging-interceptor")
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        // --- Hilt (no kapt, just ksp) ---
        implementation("com.google.dagger:hilt-android:2.52")
        ksp("com.google.dagger:hilt-compiler:2.52")
        implementation("androidx.hilt:hilt-navigation-compose:1.3.0")

        // --- Coil ---
        implementation("io.coil-kt:coil-compose:2.5.0")

        // --- Testing ---
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.2.1")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}