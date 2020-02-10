package kg.mirlan.testlifehacker.ui.posts

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testalbumapp.utils.diffItemCallback
import com.example.testalbumapp.utils.inflate
import com.squareup.picasso.Picasso
import kg.mirlan.testlifehacker.R
import kg.mirlan.testlifehacker.model.Post
import timber.log.Timber

class PostsAdapter(
    private val click: (Post) -> Unit
) :
    ListAdapter<Post, PostsAdapter.ViewHolder>(
        diffItemCallback { it.first == it.second }
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_post_list))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val name: TextView = itemView.findViewById(R.id.title)
        private val image: ImageView = itemView.findViewById(R.id.image)
        fun bind(post: Post?) {
            name.text = post?.title?.rendered
            Picasso
                .get()
                .load(post?.cover?.sizes?.mobile)
                .into(image)
            Timber.e(post?.cover?.sizes?.mobile)
            itemView.setOnClickListener {
                click(getItem(adapterPosition) ?: return@setOnClickListener)
            }
        }
    }
}