package com.nerdery.artists.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nerdery.artists.di.ViewModelFactory
import com.nerdery.artists.di.ViewModelKey
import com.nerdery.artists.ui.details.DetailsActivityViewModelImpl
import com.nerdery.artists.ui.favorite.FavoriteArtistsFragmentViewModelImpl
import com.nerdery.artists.ui.favorite.FavoriteEventsFragmentViewModelImpl
import com.nerdery.artists.ui.main.MainActivityViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Module class used to inject dependencies in the ViewModels
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModelImpl::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModelImpl: MainActivityViewModelImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteArtistsFragmentViewModelImpl::class)
    abstract fun bindFavoriteArtistsFragmentViewModel(favoriteArtistsFragmentViewModelImpl: FavoriteArtistsFragmentViewModelImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteEventsFragmentViewModelImpl::class)
    abstract fun bindFavoriteEventsFragmentViewModel(favoriteEventsFragmentViewModelImpl: FavoriteEventsFragmentViewModelImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsActivityViewModelImpl::class)
    abstract fun bindDetailsActivityViewModelImpl(detailsActivityViewModelImpl: DetailsActivityViewModelImpl): ViewModel

}


