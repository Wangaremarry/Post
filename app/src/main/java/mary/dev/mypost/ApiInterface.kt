package mary.dev.mypost

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getpost():Call<List<Post>>
    @GET("/post/{id}")
    fun getPostById(@Path("id")postId:Int):Call<Post>
}