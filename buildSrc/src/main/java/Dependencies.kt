object Dependencies {

    val material by  lazy {
        "com.google.android.material:material:${Versions.material}"
    }
    val coreKtx by lazy {
        "androidx.core:core-ktx:${Versions.coreKtx}"
    }
    val  appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
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
    val hiltAndroid by lazy{"com.google.dagger:hilt-android:${Versions.hilt}"}
    val hiltAndroidCompiler by lazy{"com.google.dagger:hilt-android-compiler:${Versions.hilt}"}
    val hiltCompiler by lazy{"androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"}


    val lifecycleViewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtx}" }

}

object Modules{
    const val utilities=":utilities"
}