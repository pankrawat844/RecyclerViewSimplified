package come.texi.recyclerviewsimplified.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import come.texi.recyclerviewsimplified.MoviesViewModel
import come.texi.recyclerviewsimplified.repository.MoviesRepository

class MovieViewModelFactory(
    private val repository: MoviesRepository
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repository) as T

    }
}