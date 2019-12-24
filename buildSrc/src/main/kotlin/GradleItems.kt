object GradleItems {
    object Dependencies {
        val Android = "com.android.tools.build:gradle:${Versions.Gradle}"
        val Kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}"
        val Navigation_SafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.AndroidX.Navigation}"
        val JUnitAndroid = "de.mannodermaus.gradle.plugins:android-junit5:${Versions.JUnitAndroid}"
        val Jacoco = "org.jacoco:org.jacoco.core:${Versions.Jacoco}"
    }

    object Plugins {
        val JUnitAndroid = "de.mannodermaus.android-junit5"
        val Jacoco = "jacoco"

        object Java {
            val Library = "java-library"
        }

        object Kotlin {
            val Core = "kotlin"
            val Android = "kotlin-android"
            val Extensions = "kotlin-android-extensions"
            val Kapt = "kotlin-kapt"
        }

        object Android {
            val App = "com.android.application"
            val Library = "com.android.library"
        }

        object AndroidX {
            val SafeArgs = "androidx.navigation.safeargs"
            val SafeArgs_Kotlin = "androidx.navigation.safeargs.kotlin"
        }

        object Firebase {
            val Performance = "com.google.firebase.firebase-perf"
        }
    }
}
