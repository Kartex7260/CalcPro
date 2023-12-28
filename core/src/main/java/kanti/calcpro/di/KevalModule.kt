package kanti.calcpro.di

import com.notkamui.keval.Keval
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KevalModule {

	@Provides
	@Singleton
	fun provideKeval(): Keval {
		return Keval()
	}
}