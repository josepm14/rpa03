plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Puedes quitar compose si no lo usas
    // alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services") // 🔹 Plugin para Firebase
}

android {
    namespace = "pinares.mejia.pa3.org"
    compileSdk = 36

    defaultConfig {
        applicationId = "pinares.mejia.pa3.org"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        // Si trabajas con XML: deja "viewBinding = true"
        // Si trabajas con Compose: deja "compose = true"
        viewBinding = true
        // compose = true
    }
}

dependencies {
    // Dependencias base
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation("com.google.android.material:material:1.13.0")

    // Firebase (usando BoM para manejar versiones)
    implementation(platform("com.google.firebase:firebase-bom:34.3.0"))
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-analytics")

    // (Opcional) si quieres Firebase Authentication en el futuro:
    // implementation("com.google.firebase:firebase-auth")

    // Jetpack Compose (si decides usarlo)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.animated.vector.drawable)
    implementation(libs.androidx.vectordrawable.animated)
    implementation(libs.appcompat.v7)
    implementation(libs.androidx.appcompat)
    implementation(libs.car)
    implementation(libs.androidx.car)
    implementation(libs.cardview.v7)
    implementation(libs.androidx.cardview)
    implementation(libs.collections)
    implementation(libs.androidx.collection)
    implementation(libs.customtabs)
    implementation(libs.androidx.browser)
    implementation(libs.design)
    implementation(libs.exifinterface)
    implementation(libs.androidx.exifinterface)
    implementation(libs.gridlayout.v7)
    implementation(libs.androidx.gridlayout)
    implementation(libs.heifwriter)
    implementation(libs.androidx.heifwriter)
    implementation(libs.leanback.v17)
    implementation(libs.androidx.leanback)
    implementation(libs.mediarouter.v7)
    implementation(libs.androidx.mediarouter)
    implementation(libs.multidex)
    implementation(libs.androidx.multidex)
    implementation(libs.multidex.instrumentation)
    implementation(libs.androidx.multidex.instrumentation)
    implementation(libs.palette.v7)
    implementation(libs.androidx.palette)
    implementation(libs.percent)
    implementation(libs.androidx.percentlayout)
    implementation(libs.preference.leanback.v17)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
