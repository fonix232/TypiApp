package net.fonix232.typiapp.network

import kotlin.reflect.full.memberProperties
import net.fonix232.typiapp.domain.model.Album as DomainAlbum
import net.fonix232.typiapp.domain.model.Comment as DomainComment
import net.fonix232.typiapp.domain.model.Photo as DomainPhoto
import net.fonix232.typiapp.domain.model.Post as DomainPost
import net.fonix232.typiapp.domain.model.Todo as DomainTodo
import net.fonix232.typiapp.domain.model.User as DomainUser
import net.fonix232.typiapp.domain.model.User.Address as DomainAddress
import net.fonix232.typiapp.domain.model.User.Address.Geolocation as DomainLocation
import net.fonix232.typiapp.domain.model.User.Company as DomainCompany
import net.fonix232.typiapp.network.model.Album as NetworkAlbum
import net.fonix232.typiapp.network.model.Comment as NetworkComment
import net.fonix232.typiapp.network.model.Photo as NetworkPhoto
import net.fonix232.typiapp.network.model.Post as NetworkPost
import net.fonix232.typiapp.network.model.Todo as NetworkTodo
import net.fonix232.typiapp.network.model.User as NetworkUser
import net.fonix232.typiapp.network.model.User.Address as NetworkAddress
import net.fonix232.typiapp.network.model.User.Address.Geolocation as NetworkLocation
import net.fonix232.typiapp.network.model.User.Company as NetworkCompany


internal fun DomainAlbum.toNetwork(): NetworkAlbum = with(::NetworkAlbum) {
    val propertiesByName = DomainAlbum::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toNetwork)
        }
    })
}

internal fun NetworkAlbum.toDomain(): DomainAlbum = with(::DomainAlbum) {
    val propertiesByName = NetworkAlbum::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            DomainAlbum::photos.name -> listOf<DomainPhoto>()
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainComment.toNetwork(): NetworkComment = with(::NetworkComment) {
    val propertiesByName = DomainComment::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toNetwork)
        }
    })
}

internal fun NetworkComment.toDomain(): DomainComment = with(::DomainComment) {
    val propertiesByName = NetworkComment::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainPhoto.toNetwork(): NetworkPhoto = with(::NetworkPhoto) {
    val propertiesByName = DomainPhoto::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toNetwork)
        }
    })
}

internal fun NetworkPhoto.toDomain(): DomainPhoto = with(::DomainPhoto) {
    val propertiesByName = NetworkPhoto::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainPost.toNetwork(): NetworkPost = with(::NetworkPost) {
    val propertiesByName = DomainPost::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toNetwork)
        }
    })
}

internal fun NetworkPost.toDomain(): DomainPost = with(::DomainPost) {
    val propertiesByName = NetworkPost::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            DomainPost::comments.name -> listOf<DomainComment>()
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainTodo.toNetwork(): NetworkTodo = with(::NetworkTodo) {
    val propertiesByName = DomainTodo::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toNetwork)
        }
    })
}

internal fun NetworkTodo.toDomain(): DomainTodo = with(::DomainTodo) {
    val propertiesByName = NetworkTodo::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainUser.toNetwork(): NetworkUser = with(::NetworkUser) {
    val propertiesByName = DomainUser::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            DomainUser::address.name -> address.toNetwork()
            DomainUser::company.name -> company.toNetwork()
            else -> propertiesByName[parameter.name]?.get(this@toNetwork)
        }
    })
}

internal fun NetworkUser.toDomain(): DomainUser = with(::DomainUser) {
    val propertiesByName = NetworkUser::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            NetworkUser::address.name -> address.toDomain()
            NetworkUser::company.name -> company.toDomain()
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}


internal fun DomainAddress.toNetwork(): NetworkAddress = with(::NetworkAddress) {
    val propertiesByName = DomainAddress::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            DomainAddress::location.name -> location.toNetwork()
            else -> propertiesByName[parameter.name]?.get(this@toNetwork)
        }
    })
}

internal fun NetworkAddress.toDomain(): DomainAddress = with(::DomainAddress) {
    val propertiesByName = NetworkAddress::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            NetworkAddress::location.name -> location.toDomain()
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainLocation.toNetwork(): NetworkLocation = with(::NetworkLocation) {
    val propertiesByName = DomainLocation::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toNetwork)
        }
    })
}

internal fun NetworkLocation.toDomain(): DomainLocation = with(::DomainLocation) {
    val propertiesByName = NetworkLocation::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

internal fun DomainCompany.toNetwork(): NetworkCompany = with(::NetworkCompany) {
    val propertiesByName = DomainCompany::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toNetwork)
        }
    })
}

internal fun NetworkCompany.toDomain(): DomainCompany = with(::DomainCompany) {
    val propertiesByName = NetworkCompany::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toDomain)
        }
    })
}

