/*
 * This file is part of TypiApp (https://github.com/fonix232/TypiApp/)
 * Copyright (c) 2019 Jozsef Kiraly <fonix232@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

import extensions.applyDefaults

plugins {
    id(GradleItems.Plugins.Android.Library)
    id(GradleItems.Plugins.Kotlin.Android)
    id(GradleItems.Plugins.Kotlin.Extensions)
    id(GradleItems.Plugins.Kotlin.Kapt)
}

android.applyDefaults(project)

dependencies {
    // Local modules
    implementation(project(":domain"))

    // Kotlin
    implementation(Dependencies.Kotlin.StdLib_JDK8)
    implementation(Dependencies.Kotlin.Reflect)
    implementation(Dependencies.Kotlin.Coroutines.Android)

    // Dependency Injection
    implementation(Dependencies.Koin.Android)

    // Retrofit
    implementation(Dependencies.Networking.Retrofit.Core)
    implementation(Dependencies.Networking.Retrofit.Serializers.Moshi)

    // OkHttp
    implementation(Dependencies.Networking.OkHttp.Core)
    implementation(Dependencies.Networking.OkHttp.HttpLoggingInterceptor)

    // Moshi
    implementation(Dependencies.Data.Moshi.Core)
    implementation(Dependencies.Data.Moshi.Kotlin)
    kapt(Dependencies.Data.Moshi.Processor)
}
