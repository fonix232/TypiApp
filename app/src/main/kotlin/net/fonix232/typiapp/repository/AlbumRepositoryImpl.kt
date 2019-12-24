package net.fonix232.typiapp.repository

import net.fonix232.typiapp.base.repository.BaseRepositoryWithSupertypeAndChildren
import net.fonix232.typiapp.domain.client.AlbumClient
import net.fonix232.typiapp.domain.db.AlbumDatabase
import net.fonix232.typiapp.domain.model.Album
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.domain.repository.AlbumRepository

class AlbumRepositoryImpl(override val client: AlbumClient, override val database: AlbumDatabase) :
    BaseRepositoryWithSupertypeAndChildren<Album, User>(), AlbumRepository
