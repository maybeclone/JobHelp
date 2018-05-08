package com.slient.jobhelp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.slient.jobhelp.R
import com.slient.jobhelp.configs.ConfigIntent
import kotlinx.android.synthetic.main.activity_detail_news.*
import java.lang.StringBuilder

class DetailNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        detailNewsToolbar.setTitle(getString(R.string.title_toolbar_content))
        setSupportActionBar(detailNewsToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        detailNewsToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val url = intent.getStringExtra(ConfigIntent.EXTRA_URL_NEWS)
        val string = StringBuilder(url)
        string.insert(8,"m.")
        webView.loadUrl(string.toString())
    }
}
