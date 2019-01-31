package com.nerdery.artists.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import com.nerdery.artists.NerderyArtistsApplication
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    @Singleton
    @Provides
    fun provideApplicationContext(application: NerderyArtistsApplication): Context =
            application.applicationContext

}