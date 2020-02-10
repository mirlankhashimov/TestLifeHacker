package kg.mirlan.testlifehacker.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Post(
    val title: Title = Title(),
    val content: Content = Content(),
    @SerializedName("cat_cover")
    val cover: Cover = Cover()
)

data class Title(val rendered: String? = "")
data class Content(val rendered: String? = "")
data class Cover(val sizes: Sizes? = null)
data class Sizes(val mobile: String? = "")
//"title":{
//    "rendered":"Samsung \u043f\u0440\u0435\u0434\u0441\u0442\u0430\u0432\u0438\u043b\u0430 Galaxy Z Flip \u043f\u0440\u044f\u043c\u043e \u0432\u043e \u0432\u0440\u0435\u043c\u044f \u00ab\u041e\u0441\u043a\u0430\u0440\u0430\u00bb"
//},
//"content":{
//    "rendered":"<p>"
//    cat_cover":{
//    "sizes":{
//        "large":null,
//        "mobile":null,
//        "post-thumbnail":null,
//        "highres":null
//    }
//},