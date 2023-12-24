object Dependencies {

    val material by lazy {
        "com.google.android.material:material:${Versions.material}"
    }
    val coreKtx by lazy {
        "androidx.core:core-ktx:${Versions.coreKtx}"
    }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val lifeCycleRunTimeKtx by lazy {
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleRunTimeKtx}"
    }
    val activityCompose by lazy {
        "androidx.activity:activity-compose:${Versions.activityCompose}"
    }
    val activityBom by lazy {
        "androidx.compose:compose-bom:${Versions.activityBom}"
    }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeUiGraphic by lazy { "androidx.compose.ui:ui-graphics" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navigationCompose}" }
    val composeTestJunit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}" }
    val lifecycleViewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtx}" }

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val okHttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okHttp}" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}" }
    val moshi by lazy { "com.squareup.moshi:moshi:${Versions.moshi}" }
    val moshiKotlin by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshiKotlin}" }
    val moshiConvertor by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConvertor}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }

    val coroutineCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}" }
    val coroutineAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}" }
    val splashScreen by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }

}

object Modules {
    const val utilities = ":utilities"
}