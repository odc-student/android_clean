package tn.orange.demoapp.authentication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tn.orange.demoapp.authentication.data.ApiService
import tn.orange.demoapp.authentication.data.RealRemoteService
import tn.orange.demoapp.authentication.data.RemoteService
import tn.orange.demoapp.authentication.domain.PokemonRepository
import tn.orange.demoapp.authentication.domain.usecase.FetchPokemonUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesApiService() = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesRemoteService(apiService: ApiService): RemoteService = RealRemoteService(apiService)

    @Provides
    fun providesRepository(remoteService: RemoteService) = PokemonRepository(remoteService)

    @Provides
    fun providesFetchPokemonUseCase(repository: PokemonRepository) = FetchPokemonUseCase(repository)
}