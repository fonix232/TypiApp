package net.fonix232.typiapp.persistence

import net.fonix232.typiapp.persistence.model.AlbumWithPhotos
import net.fonix232.typiapp.persistence.model.PostWithComments
import kotlin.reflect.full.memberProperties
import net.fonix232.typiapp.domain.model.Album as DomainAlbum
import net.fonix232.typiapp.domain.model.Comment as DomainComment
import net.fonix232.typiapp.domain.model.Photo as DomainPhoto
import net.fonix232.typiapp.domain.model.Post as DomainPost
import net.fonix232.typiapp.domain.model.Todo as DomainTodo
import net.fonix232.typiapp.domain.model.User as DomainUser
import net.fonix232.typiapp.domain.model.User.Address as DomainAddress
import net.fonix232.typiapp.domain.model.User.Company as DomainCompany
import net.fonix232.typiapp.persistence.model.Album as DbAlbum
import net.fonix232.typiapp.persistence.model.Comment as DbComment
import net.fonix232.typiapp.persistence.model.Photo as DbPhoto
import net.fonix232.typiapp.persistence.model.Post as DbPost
import net.fonix232.typiapp.persistence.model.Todo as DbTodo
import net.fonix232.typiapp.persistence.model.User as DbUser
import net.fonix232.typiapp.persistence.model.User.Address as DbAddress
import net.fonix232.typiapp.persistence.model.User.Company as DbCompany


internal fun DomainAlbum.toDb(): DbAlbum = with(::DbAlbum) {
    val propertiesByName = DomainAlbum::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDb)
        }
    })
}

internal fun DbAlbum.toDomain(): DomainAlbum = with(::DomainAlbum) {
    val propertiesByName = DbAlbum::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun AlbumWithPhotos.toDomain(): DomainAlbum =
    this.album.toDomain().copy(photos = this.photos.map { it.toDomain() })

internal fun DomainComment.toDb(): DbComment = with(::DbComment) {
    val propertiesByName = DomainComment::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDb)
        }
    })
}

internal fun DbComment.toDomain(): DomainComment = with(::DomainComment) {
    val propertiesByName = DbComment::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainPhoto.toDb(): DbPhoto = with(::DbPhoto) {
    val propertiesByName = DomainPhoto::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            DbPhoto::photoUrl.name -> url
            else -> propertiesByName[parameter.name]?.get(this@toDb)
        }
    })
}

internal fun DbPhoto.toDomain(): DomainPhoto = with(::DomainPhoto) {
    val propertiesByName = DbPhoto::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            DomainPhoto::url.name -> photoUrl
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainPost.toDb(): DbPost = with(::DbPost) {
    val propertiesByName = DomainPost::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDb)
        }
    })
}

internal fun DbPost.toDomain(): DomainPost = with(::DomainPost) {
    val propertiesByName = DbPost::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun PostWithComments.toDomain(): DomainPost =
    this.toDomain().copy(comments = this.comments.map { it.toDomain() })

internal fun DomainTodo.toDb(): DbTodo = with(::DbTodo) {
    val propertiesByName = DomainTodo::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDb)
        }
    })
}

internal fun DbTodo.toDomain(): DomainTodo = with(::DomainTodo) {
    val propertiesByName = DbTodo::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainUser.toDb(): DbUser = with(::DbUser) {
    val propertiesByName = DomainUser::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            DomainUser::address.name -> address.toDb()
            DomainUser::company.name -> company.toDb()
            else -> propertiesByName[parameter.name]?.get(this@toDb)
        }
    })
}

internal fun DbUser.toDomain(): DomainUser = with(::DomainUser) {
    val propertiesByName = DbUser::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            DbUser::address.name -> address.toDomain()
            DbUser::company.name -> company.toDomain()
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainAddress.toDb(): DbAddress = with(::DbAddress) {
    val propertiesByName = DomainAddress::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            DbAddress::latitude.name -> location.latitude
            DbAddress::longitude.name -> location.longitude
            else -> propertiesByName[parameter.name]?.get(this@toDb)
        }
    })
}

internal fun DbAddress.toDomain(): DomainAddress = with(::DomainAddress) {
    val propertiesByName = DbAddress::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            DomainAddress::location.name -> DomainAddress.Geolocation(latitude, longitude)
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainCompany.toDb(): DbCompany = with(::DbCompany) {
    val propertiesByName = DomainCompany::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDb)
        }
    })
}

internal fun DbCompany.toDomain(): DomainCompany = with(::DomainCompany) {
    val propertiesByName = DbCompany::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}
