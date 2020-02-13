package kg.mirlan.testlifehacker.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso
import kg.mirlan.testlifehacker.R
import kg.mirlan.testlifehacker.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail.*


class PostFragment : BaseFragment(R.layout.fragment_detail) {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title.text = arguments?.getString("postTitle")
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener {
            view.let {
                Navigation.findNavController(it).popBackStack()
            }
        }
        val html = arguments?.getString("postContent")
        webview.settings.javaScriptEnabled = true
        webview.loadDataWithBaseURL("", html, "text/html", "UTF-8", "")
    }
}