package net.fonix232.typiapp.repository

import net.fonix232.typiapp.base.repository.BaseRepositoryWithSupertype
import net.fonix232.typiapp.domain.client.IClientWithSupertype
import net.fonix232.typiapp.domain.client.PhotoClient
import net.fonix232.typiapp.domain.db.IDatabaseWithSupertype
import net.fonix232.typiapp.domain.db.PhotoDatabase
import net.fonix232.typiapp.domain.model.Album
import net.fonix232.typiapp.domain.model.Photo
import net.fonix232.typiapp.domain.repository.PhotoRepository
import org.koin.core.inject

class PhotoRepositoryImpl(override val client: PhotoClient, override val database: PhotoDatabase):
    BaseRepositoryWithSupertype<Photo, Album>(), PhotoRepository
