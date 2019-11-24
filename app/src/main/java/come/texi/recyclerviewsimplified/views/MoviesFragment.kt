    package come.texi.recyclerviewsimplified.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import come.texi.recyclerviewsimplified.MovieApi
import come.texi.recyclerviewsimplified.MoviesViewModel
import come.texi.recyclerviewsimplified.R
import come.texi.recyclerviewsimplified.repository.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch


    class MoviesFragment : Fragment() {

        companion object {
            fun newInstance() =
                MoviesFragment()
        }

        private lateinit var viewModel: MoviesViewModel
        private lateinit var factory: MovieViewModelFactory
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.movies_fragment, container, false)
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            val api = MovieApi()
            val repository = MoviesRepository(api)
            factory = MovieViewModelFactory(repository)
            viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)
            CoroutineScope(Main).launch {
                viewModel.getMovies()
            }
            viewModel.movies.observe(viewLifecycleOwner, Observer { it ->
                Log.e("TAG", "onActivityCreated: ",it.toString() )
            })

        }
    }