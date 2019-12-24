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
    // Kotlin
    implementation(Dependencies.Kotlin.StdLib_JDK8)
    implementation(Dependencies.Kotlin.Coroutines.Android)

    // Lifecycle
    implementation(Dependencies.AndroidX.Lifecycle.Runtime_Ktx)
    implementation(Dependencies.AndroidX.Lifecycle.Livedata_Ktx)
    implementation(Dependencies.AndroidX.Lifecycle.Viewmodel_Ktx)
    implementation(Dependencies.AndroidX.Lifecycle.Extensions)
    implementation(Dependencies.AndroidX.Lifecycle.Common_Java8)

    // Dependency Injection
    implementation(Dependencies.Koin.Android)
}
