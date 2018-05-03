package com.slient.jobhelp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.slient.jobhelp.R
import kotlinx.android.synthetic.main.activity_multi_choice.*

class MultipleChoiceQuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_choice)
        setupProgressGroupStepView()
    }

    private fun setupProgressGroupStepView(){
        progressGroupStepView.labels = arrayOf("Table A", "Table B", "Table C", "Table D", "Table E", "Table F")
        progressGroupStepView.barColorIndicator = resources.getColor(R.color.colorStepViewBackground)
        progressGroupStepView.progressColorIndicator = resources.getColor(R.color.colorStepViewForeground)
    }
}
