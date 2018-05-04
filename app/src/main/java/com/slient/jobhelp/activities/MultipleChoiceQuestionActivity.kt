package com.slient.jobhelp.activities

import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import com.slient.jobhelp.R
import com.slient.jobhelp.adapters.QuestionAdapter
import com.slient.jobhelp.callbacks.QuestionCallback
import com.slient.jobhelp.models.data.LabelGroupQuestion
import com.slient.jobhelp.models.database.data.Question
import com.slient.jobhelp.models.database.dbhelper.AppDatabase
import com.slient.jobhelp.utils.GroupQuestionUtils
import kotlinx.android.synthetic.main.activity_multi_choice.*

class MultipleChoiceQuestionActivity : AppCompatActivity(), View.OnClickListener, QuestionCallback {

    var databaseAccess: AppDatabase? = null
    var mapQuestions = HashMap<LabelGroupQuestion, List<Question>>()
    val mapPoints = HashMap<LabelGroupQuestion, Int>()
    val adapter = QuestionAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_choice)
        setupProgressGroupStepView()
        init()
    }

    private fun init() {
        databaseAccess = AppDatabase.getInstance(this)
        continueButton.setOnClickListener(this)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider_item_question))
        questionsRecyclerView.addItemDecoration(dividerItemDecoration)
        questionsRecyclerView.adapter = adapter
        LoadingDBDataTask().execute()
    }

    private fun setupProgressGroupStepView() {
        val labels = arrayOfNulls<String>(LabelGroupQuestion.values().size)
        val labelDefault = getString(R.string.label_table_group)
        LabelGroupQuestion.values().forEach {
            labels[it.ordinal] = labelDefault + " " + it.toString()
        }
        progressGroupStepView.labels = labels
        progressGroupStepView.barColorIndicator = resources.getColor(R.color.colorStepViewBackground)
        progressGroupStepView.progressColorIndicator = resources.getColor(R.color.colorStepViewForeground)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.continueButton -> {
                if (adapter.getQuestions() != null) {
                    mapPoints[adapter.getLabelGroupQuestion()] = adapter.getTotalPoint()
                    val index = adapter.getLabelGroupQuestion().ordinal + 1
                    if (index < LabelGroupQuestion.values().size) {
                        progressGroupStepView.setCompletedPosition(index)
                        progressGroupStepView.drawView()
                        val label = LabelGroupQuestion.values()[index]
                        adapter.swapQuestion(label, mapQuestions!![label])
                        questionsRecyclerView.scrollToPosition(0)
                        continueButton.isEnabled = false
                        if (index == LabelGroupQuestion.values().size - 1 ) {
                            continueButton.text = getString(R.string.title_button_continue_show_result)
                        }
                    } else {
                        val labels = GroupQuestionUtils.getMaxPointGroup(mapPoints)
                        s
                    }
                }
            }
        }
    }

    override fun setEnableForButton(enable: Boolean) {
        continueButton.isEnabled = enable
    }

    inner class LoadingDBDataTask: AsyncTask<Context, Void, HashMap<LabelGroupQuestion, List<Question>>>() {

        override fun onPreExecute() {
            super.onPreExecute()
            loadingFromDBProgressBar.visibility = View.VISIBLE
            questionsRecyclerView.visibility = View.INVISIBLE
        }

        override fun doInBackground(vararg params: Context?): HashMap<LabelGroupQuestion, List<Question>> {
            val loadingMap = HashMap<LabelGroupQuestion, List<Question>>()
            if (databaseAccess != null) {
                loadingMap.put(LabelGroupQuestion.A, databaseAccess!!.questionDAO().getQuestionFollowGroup(LabelGroupQuestion.A.toString()))
                loadingMap.put(LabelGroupQuestion.B, databaseAccess!!.questionDAO().getQuestionFollowGroup(LabelGroupQuestion.B.toString()))
                loadingMap.put(LabelGroupQuestion.C, databaseAccess!!.questionDAO().getQuestionFollowGroup(LabelGroupQuestion.C.toString()))
                loadingMap.put(LabelGroupQuestion.D, databaseAccess!!.questionDAO().getQuestionFollowGroup(LabelGroupQuestion.D.toString()))
                loadingMap.put(LabelGroupQuestion.E, databaseAccess!!.questionDAO().getQuestionFollowGroup(LabelGroupQuestion.E.toString()))
                loadingMap.put(LabelGroupQuestion.F, databaseAccess!!.questionDAO().getQuestionFollowGroup(LabelGroupQuestion.F.toString()))
            }
            return loadingMap
        }

        override fun onPostExecute(result: HashMap<LabelGroupQuestion, List<Question>>) {
            super.onPostExecute(result)
            loadingFromDBProgressBar.visibility = View.INVISIBLE
            questionsRecyclerView.visibility = View.VISIBLE
            mapQuestions = result
            val adapter = questionsRecyclerView.adapter as QuestionAdapter
            adapter.swapQuestion(LabelGroupQuestion.A, mapQuestions.get(LabelGroupQuestion.A)!!)

        }

    }
}
