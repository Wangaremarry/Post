package mary.dev.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import mary.dev.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        Toast.makeText(applicationContext, "abcd", Toast.LENGTH_LONG).show()
        getPosts()
    }
    fun getPosts(){
        val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
        val request=retrofit.getpost()
        request.enqueue(object:Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    Toast.makeText(applicationContext, "fetched ${post!!.size} posts",
                        Toast.LENGTH_LONG
                    ).show()
                    var adapter=PostRVAdapter(baseContext,post)
                    Log.d("Tag",getPosts().toString())
                    binding.rv.adapter=adapter
                    binding.rv.layoutManager=LinearLayoutManager(baseContext)

                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}

