package lmd.pet.weathernew.data.dataSource.cities

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import lmd.pet.weathernew.core.network.CitiesNetworkSource
import lmd.pet.weathernew.data.entity.dao.cities.CityModel

@ExperimentalPagingApi
class CitiesRemoteMediator(
    private val network: CitiesNetworkSource,
    private val dataBase: CitiesDataBase
): RemoteMediator<Int, CityModel>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CityModel>
    ): MediatorResult {
        return try {

        }
    }


}