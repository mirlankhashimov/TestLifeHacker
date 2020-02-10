package kg.mirlan.testlifehacker.ui.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kg.mirlan.testlifehacker.core.BaseViewModel
import kg.mirlan.testlifehacker.model.Post
import kg.mirlan.testlifehacker.repo.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel(
    private val postsRepository: PostsRepository
) : BaseViewModel() {
    val posts = postsRepository.posts
}