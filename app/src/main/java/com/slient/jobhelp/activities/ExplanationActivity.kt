package com.slient.jobhelp.activities

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import com.slient.jobhelp.R
import com.slient.jobhelp.adapters.GroupAdapter
import com.slient.jobhelp.configs.ConfigIntent
import com.slient.jobhelp.models.data.LabelGroupQuestion
import com.slient.jobhelp.models.database.data.GroupQuestion
import com.slient.jobhelp.models.database.dbhelper.AppDatabase
import kotlinx.android.synthetic.main.activity_explanation.*
import kotlinx.android.synthetic.main.item_explanation_group.*

class ExplanationActivity : AppCompatActivity() {

    var groupQuestions = ArrayList<GroupQuestion>()
    val adapter = GroupAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explanation)
        init()
    }

    private fun init(){
        groupQuestionRecyclerView.adapter = adapter
        val maxingLabels = intent.getSerializableExtra(ConfigIntent.EXTRA_LIST_GROUP) as java.util.ArrayList<LabelGroupQuestion>
        toolBar.setTitle(getString(R.string.title_toolbar_explain_activity))
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        LoadingGroupQuestionFromDatabaseTask().execute(maxingLabels)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.explanain_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_share -> {
                val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = getString(R.string.title_toolbar_explain_activity)
                var shareSub = StringBuilder()
                groupQuestions.forEach {
                    shareSub.append(it.explanation+'\n')
                }
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub.toString())
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
                startActivity(Intent.createChooser(sharingIntent, "Share using"))
            }
            R.id.menu_reset -> {
                startActivity(Intent(this, MultipleChoiceQuestionActivity::class.java))
                finish()
            }
        }
        return true
    }

    inner class LoadingGroupQuestionFromDatabaseTask: AsyncTask<ArrayList<LabelGroupQuestion>, Void, ArrayList<GroupQuestion>?>() {

        override fun onPreExecute() {
            super.onPreExecute()
            loadingFromDBProgressBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: ArrayList<LabelGroupQuestion>?): ArrayList<GroupQuestion>? {
            val databaseAccess = AppDatabase.getInstance(this@ExplanationActivity)
            val groupQuestions = ArrayList<GroupQuestion>()
            params[0]?.forEach {
                groupQuestions.add(databaseAccess?.groupQuestionDAO()?.getGroupQuestionFollowId(it.toString())!!)
            }
            return groupQuestions
        }

        override fun onPostExecute(result: ArrayList<GroupQuestion>?) {
            super.onPostExecute(result)
            loadingFromDBProgressBar.visibility = View.GONE
            groupQuestions = result!!
            adapter.swapList(groupQuestions)
        }

    }
}
