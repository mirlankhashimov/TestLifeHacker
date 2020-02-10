package kg.mirlan.testlifehacker.api

import kg.mirlan.testlifehacker.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("posts")
    suspend fun getPosts(): List<Post>

}