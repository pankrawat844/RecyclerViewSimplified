package come.texi.recyclerviewsimplified

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import come.texi.recyclerviewsimplified.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository=MoviesRepository(MovieApi())
        GlobalScope.launch(Dispatchers.Main) {
            val movies=repository.getMovies()
            Toast.makeText(this@MainActivity,movies.toString(),2).show()
        }

    }
}
