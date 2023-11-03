package com.example.testapp.di

import android.content.Context
import androidx.room.Room
import com.example.testapp.domain.repository.DataRepository
import com.example.testapp.data.common.Constants.BASE_URL
import com.example.testapp.data.common.Constants.DATABASE_NAME
import com.example.testapp.data.local.DataDao
import com.example.testapp.data.local.DataDatabase
import com.example.testapp.data.remote.ApiService
import com.example.testapp.data.repository.DataListRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * @author : Mingaleev D
 * @data : 02.11.2023
 *
 * по хорошему нужно разделить модули, но сейчас пока все в одном
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   @Provides
   @Singleton
   fun provideOkHttpClient(): OkHttpClient {
      return OkHttpClient.Builder()
          .build()
   }

   @Provides
   @Singleton
   fun provideGsonConverterFactory(): GsonConverterFactory {
      return GsonConverterFactory.create()
   }

   @Provides
   @Singleton
   fun provideRecipeApi(
       client: OkHttpClient,
       converterFactory: GsonConverterFactory
   ): ApiService {
      return Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(converterFactory)
          .client(client)
          .build()
          .create()
   }

   @Singleton
   @Provides
   fun provideDataRepository(
       api: ApiService,
       dao: DataDao
   ): DataRepository = DataListRepositoryImp(api = api, dao = dao)

   @Provides
   @Singleton
   fun provideDataDatabase(
       @ApplicationContext context: Context
   ) = Room.databaseBuilder(context, DataDatabase::class.java, DATABASE_NAME).build()

   @Provides
   @Singleton
   fun provideDataDao(db: DataDatabase) = db.dataDao()
}