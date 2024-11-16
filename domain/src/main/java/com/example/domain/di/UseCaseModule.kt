package com.example.domain.di

import com.example.domain.repo.DetailsRepo
import com.example.domain.repo.ImageRepo
import com.example.domain.repo.MovieRepo
import com.example.domain.repo.SearchRepo
import com.example.domain.usecase.details_usecase.DetailsUSeCaseRepo
import com.example.domain.usecase.details_usecase.DetailsUseCase
import com.example.domain.usecase.details_usecase.image_usecase.ImageUseCase
import com.example.domain.usecase.details_usecase.image_usecase.ImageUseCaseRepo
import com.example.domain.usecase.nowplaying_usecase.NowPlayingUseCase
import com.example.domain.usecase.nowplaying_usecase.NowPlayingUseCaseRepo
import com.example.domain.usecase.popular_usecase.PopularUseCase
import com.example.domain.usecase.popular_usecase.PopularUseCaseRepo
import com.example.domain.usecase.search_usecase.SearchUseCase
import com.example.domain.usecase.search_usecase.SearchUseCaseRepo
import com.example.domain.usecase.toprated_usecase.TopRatedUseCase
import com.example.domain.usecase.toprated_usecase.TopRatedUseCaseRepo
import com.example.domain.usecase.upcoming_usecase.UpcomingUseCase
import com.example.domain.usecase.upcoming_usecase.UpcomingUseCaseRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providePopularUseCase(popularMovies: MovieRepo): PopularUseCaseRepo {
        return PopularUseCase(popularMovies)
    }

    @Provides
    @Singleton
    fun provideTopRatedUseCase(topRatedMovies: MovieRepo): TopRatedUseCaseRepo {
        return TopRatedUseCase(topRatedMovies)
    }

    @Provides
    @Singleton
    fun provideNowPlayingUseCase(nowPlayingMovies: MovieRepo): NowPlayingUseCaseRepo {
        return NowPlayingUseCase(nowPlayingMovies)
    }

    @Provides
    @Singleton
    fun provideUpcomingUseCase(upcomingMovies: MovieRepo): UpcomingUseCaseRepo {
        return UpcomingUseCase(upcomingMovies)
    }

    @Provides
    @Singleton
    fun provideDetailsUseCase(movieDetails: DetailsRepo): DetailsUSeCaseRepo {
        return DetailsUseCase(movieDetails)
    }

    @Provides
    @Singleton
    fun provideImagesUseCase(movieImages: ImageRepo): ImageUseCaseRepo {
        return ImageUseCase(movieImages)
    }


    @Provides
    @Singleton
    fun provideSearchUseCase(searchMovie: SearchRepo): SearchUseCaseRepo {
        return SearchUseCase(searchMovie)
    }

}