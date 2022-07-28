package mary.dev.mypost

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mary.dev.mypost.databinding.PostItemListBinding
import retrofit2.Retrofit

class PostRVAdapter(var context: Context, var postList: List<Post>):
RecyclerView.Adapter<PostRVAdapter.RetrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding=PostItemListBinding.inflate(LayoutInflater.from(context),parent,false)
        return RetrofitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem=postList.get(position)
        with(holder.bindingView){
            tvid.text=currentItem.id.toString()
            tvuser.text=currentItem.userIdval.toString()
            tvtitle.text=currentItem.title
            tvbody.text=currentItem.body
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
    class RetrofitViewHolder(var bindingView:PostItemListBinding):
            RecyclerView.ViewHolder(bindingView.root)
}