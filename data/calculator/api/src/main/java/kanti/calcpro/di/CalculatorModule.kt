package kanti.calcpro.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kanti.calcpro.data.model.calculator.CalculatorRepository
import kanti.calcpro.data.model.calculator.CalculatorRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CalculatorModule {

	@Binds
	@Singleton
	fun bindCalculatorRepositoryImpl(repository: CalculatorRepositoryImpl): CalculatorRepository
}