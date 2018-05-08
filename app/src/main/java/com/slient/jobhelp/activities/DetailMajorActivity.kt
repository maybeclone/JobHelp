package com.slient.jobhelp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.slient.jobhelp.R
import com.slient.jobhelp.configs.ConfigIntent
import kotlinx.android.synthetic.main.activity_detail_major.*
import kotlinx.android.synthetic.main.activity_major.*

class DetailMajorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_major)

        init()
    }

    private fun init(){
        val nameMajor = intent.getStringExtra(ConfigIntent.EXTRA_NAME_MAJOR)
        detailMajorToolbar.title = nameMajor

        setSupportActionBar(detailMajorToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        detailMajorToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        detailMajorText.movementMethod = ScrollingMovementMethod()

        val task = FirebaseFirestore.getInstance().collection("majors").document(nameMajor).get()
        task.addOnCompleteListener {
            loadingDetailMajorProgressBar.visibility = View.GONE
            if(it.isSuccessful){
                detailMajorText.text = Html.fromHtml(it.result["message"].toString(), Html.FROM_HTML_MODE_LEGACY)
            } else {
                Toast.makeText(this, getString(R.string.toast_message_network_error), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
