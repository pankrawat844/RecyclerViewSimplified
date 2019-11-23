package come.texi.recyclerviewsimplified.repository

import come.texi.recyclerviewsimplified.MovieApi
import come.texi.recyclerviewsimplified.network.SafeApiRequest

class MoviesRepository(
    private val movieApi: MovieApi
):SafeApiRequest(){

    suspend fun getMovies()=apiRequset { movieApi.getMovies() }
}