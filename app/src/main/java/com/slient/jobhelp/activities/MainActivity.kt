package com.slient.jobhelp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.slient.jobhelp.R
import com.slient.jobhelp.models.database.dbhelper.AppDatabase
import com.slient.jobhelp.preferences.AccessConfigPreference
import com.slient.jobhelp.utils.DatabaseUtil
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener{

    var databaseHelper: AppDatabase? = null
    lateinit var accessConfigPreference: AccessConfigPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        multipleChoiceQuestionButton.setOnClickListener(this)

    }

    private fun init(){
        databaseHelper = AppDatabase.getInstance(this)
        accessConfigPreference = AccessConfigPreference.getInstance(this)

        if(accessConfigPreference.firstLauncher()){
            databaseHelper?.groupQuestionDAO()?.insert(DatabaseUtil.getAllGroupQuestion())
            databaseHelper?.questionDAO()?.insert(DatabaseUtil.getAllQuestions())
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.multipleChoiceQuestionButton -> {
                startActivity(Intent(this, MultipleChoiceQuestionActivity::class.java))
            }
        }
    }

}
