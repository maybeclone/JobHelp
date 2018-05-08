package com.slient.jobhelp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.slient.jobhelp.R
import kotlinx.android.synthetic.main.activity_major.*
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
import com.slient.jobhelp.adapters.MajorAdapter
import com.slient.jobhelp.configs.ConfigIntent
import com.slient.jobhelp.models.data.HeaderMajorGroup
import com.slient.jobhelp.models.data.Major


class MajorActivity : AppCompatActivity() {

    val adapter = MajorAdapter(null)
    val headerMajorGroupList = ArrayList<HeaderMajorGroup>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_major)

        majorToolbar.title = getString(R.string.title_toolbar_job_help)
        setSupportActionBar(majorToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        majorToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        expandableListView.setOnChildClickListener(object: ExpandableListView.OnChildClickListener{
            override fun onChildClick(parent: ExpandableListView?, v: View?, groupPosition: Int, childPosition: Int, id: Long): Boolean {
                val intent = Intent(this@MajorActivity, DetailMajorActivity::class.java)
                val major = adapter.getChild(groupPosition, childPosition) as Major
                intent.putExtra(ConfigIntent.EXTRA_NAME_MAJOR, major.name)
                startActivity(intent)
                return true
            }
        })

        expandableListView.setAdapter(adapter)
        val task = FirebaseFirestore.getInstance().collection("groups").get()
        task.addOnCompleteListener {
            groupLoadingProgressBar.visibility = View.GONE
            if(it.isSuccessful){
                it.result.documents.forEach {
                    val majorList = ArrayList<Major>()
                    it.data?.forEach {
                        majorList.add(Major(it.value.toString()))
                    }
                    headerMajorGroupList.add(HeaderMajorGroup(it.id, majorList))
                }
                adapter.swapList(headerMajorGroupList)
            } else {
                Toast.makeText(this, getString(R.string.toast_message_network_error), Toast.LENGTH_SHORT).show()
            }
        }
    }

}
