package kg.mirlan.testlifehacker

import com.google.gson.GsonBuilder
import kg.mirlan.testlifehacker.api.Api
import kg.mirlan.testlifehacker.repo.PostsRepository
import kg.mirlan.testlifehacker.ui.posts.PostsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

val appModule = module {
    single { GsonBuilder().create() }
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .connectTimeout(1, TimeUnit.MINUTES).readTimeout(1, TimeUnit.MINUTES)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://lifehacker.ru/api/wp/v2/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single { get<Retrofit>().create<Api>() }
    single { PostsRepository(get()) }
    viewModel { PostsViewModel(get()) }

}

