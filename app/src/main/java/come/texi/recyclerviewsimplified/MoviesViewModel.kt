package come.texi.recyclerviewsimplified

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import come.texi.recyclerviewsimplified.data.model.MovieResponse
import come.texi.recyclerviewsimplified.repository.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val repository:MoviesRepository
) : ViewModel() {
private val _movies=MutableLiveData<List<MovieResponse>>()
    val movies:LiveData<List<MovieResponse>>
    get() = _movies

     suspend fun getMovies()
    {
        val movies= CoroutineScope(IO).async {
            repository.getMovies()
        }.await()

        _movies.postValue(movies)
    }

}
