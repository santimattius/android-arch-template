package com.santimattius.template.di

import com.santimattius.template.data.datasources.LocalDataSource
import com.santimattius.template.data.datasources.RemoteDataSource
import com.santimattius.template.data.datasources.implementation.RoomDataSource
import com.santimattius.template.data.datasources.implementation.ServiceDataSource
import com.santimattius.template.data.datasources.implementation.client.PicSumClient
import com.santimattius.template.data.datasources.implementation.database.PicSumDataBase
import com.santimattius.template.data.repositories.PicSumRepository
import com.santimattius.template.domain.repositories.PicturesRepository
import com.santimattius.template.domain.usecases.GetPictures
import com.santimattius.template.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


private val presentationModule = module {
    viewModel { HomeViewModel(getPictures = get<GetPictures>()) }
}

private val domainModule = module {
    factory { GetPictures(repository = get<PicturesRepository>()) }
}

private val dataModule = module {

    single<PicSumClient> { PicSumClient(baseUrl = "https://picsum.photos") }

    factory<RemoteDataSource> { ServiceDataSource(client = get<PicSumClient>()) }

    factory<LocalDataSource> {
        RoomDataSource(
            database = PicSumDataBase.build(
                androidApplication()
            ),
            dispatcher = Dispatchers.IO
        )
    }

    factory<PicturesRepository> {
        PicSumRepository(
            localDataSource = get<LocalDataSource>(),
            remoteDataSource = get<RemoteDataSource>()
        )
    }

}


internal val modules = listOf(presentationModule, domainModule, dataModule)
