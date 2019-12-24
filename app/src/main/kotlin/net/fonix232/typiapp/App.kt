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

package net.fonix232.typiapp

import android.app.Application
import net.fonix232.typiapp.domain.util.Initializer
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            fragmentFactory()
            modules(
                listOf(
                    net.fonix232.typiapp.design.module,
                    net.fonix232.typiapp.domain.module,
                    net.fonix232.typiapp.persistence.module,
                    net.fonix232.typiapp.network.module,
                    net.fonix232.typiapp.base.module,
                    net.fonix232.typiapp.repositoryModule,
                    net.fonix232.typiapp.uiModule
                )
            )
        }

        GlobalContext.get().getAll<Initializer>().forEach { it.init() }
    }
}
