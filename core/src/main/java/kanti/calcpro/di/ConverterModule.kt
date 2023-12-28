package kanti.calcpro.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kanti.calcpro.core.BaseCalcElementConverter
import kanti.calcpro.core.CalcElementConverter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ConverterModule {

	@Binds
	@Singleton
	fun bindBaseCalcElementConverter(computer: BaseCalcElementConverter): CalcElementConverter
}