package kg.mirlan.testlifehacker.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kg.mirlan.testlifehacker.api.Api
import kg.mirlan.testlifehacker.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostsRepository(
    private val api: Api
) {
    val posts: LiveData<List<Post>> = liveData {
        val postsLiveData = api.getPosts()
        emit(postsLiveData)
    }
}