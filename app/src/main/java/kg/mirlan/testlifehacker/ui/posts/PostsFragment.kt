package kg.mirlan.testlifehacker.ui.posts

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import kg.mirlan.testlifehacker.R
import kg.mirlan.testlifehacker.core.BaseFragment
import kg.mirlan.testlifehacker.model.Post
import kg.mirlan.testlifehacker.utils.observe
import kotlinx.android.synthetic.main.fragment_posts.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class PostsFragment : BaseFragment(R.layout.fragment_posts) {
    private val viewModel: PostsViewModel by viewModel()
    private val albumAdapter by lazy { PostsAdapter(this::onSelectAlbum) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        posts_rv.adapter = albumAdapter
        viewModel.posts.observe(viewLifecycleOwner) {
            Timber.e(it.toString())
            albumAdapter.submitList(it)
        }
        (activity as? AppCompatActivity)?.apply {
            setSupportActionBar(toolbar)
        }
    }

    private fun onSelectAlbum(post: Post) {
        val bundle = bundleOf(
            "postTitle" to post.title.rendered,
            "postContent" to post.content.rendered
        )
        navigate(R.id.action_posts_screen_to_detail_screen, bundle)
    }

}