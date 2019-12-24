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

import extensions.addRoom
import extensions.applyDefaults

plugins {
    id(GradleItems.Plugins.Android.Library)
    id(GradleItems.Plugins.Kotlin.Android)
    id(GradleItems.Plugins.Kotlin.Extensions)
    id(GradleItems.Plugins.Kotlin.Kapt)
}

android {
    applyDefaults(project)
    addRoom(projectDir)
}

dependencies {
    // Local modules
    implementation(project(":domain"))

    // Kotlin
    implementation(Dependencies.Kotlin.StdLib_JDK8)
    implementation(Dependencies.Kotlin.Reflect)
    implementation(Dependencies.Kotlin.Coroutines.Android)

    // Dependency Injection
    implementation(Dependencies.Koin.Android)
    implementation(Dependencies.Koin.AndroidX_ViewModel)

    // Room
    implementation(Dependencies.AndroidX.Room.Runtime)
    implementation(Dependencies.AndroidX.Room.Ktx)
    implementation(Dependencies.AndroidX.Room.Common)
    implementation(Dependencies.AndroidX.Room.Migration)
    kapt(Dependencies.AndroidX.Room.Compiler)
}
