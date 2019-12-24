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

package net.fonix232.typiapp.persistence

object Constants {

    const val DATABASE_NAME = "typiapp.db"

    object TableNames {
        const val ALBUM = "albums"
        const val COMMENT = "comments"
        const val PHOTO = "photos"
        const val POST = "posts"
        const val TODO = "todo"
        const val USER = "user"
    }

    object ColumnNames {
        const val ALBUM_ID = "album_id"
        const val BODY = "body"
        const val COMPLETED = "completed"
        const val EMAIL = "email"
        const val ID = "id"
        const val NAME = "name"
        const val PHONE = "phone"
        const val PHOTO_URL = "photo_url"
        const val POST_ID = "post_id"
        const val THUMBNAIL_URL = "thumbnail_url"
        const val TITLE = "title"
        const val USERNAME = "username"
        const val USER_ID = "user_id"
        const val WEBSITE = "website"
    }

    object Prefixes {
        const val ADDRESS = "address"
        const val COMPANY = "company"
    }
}
