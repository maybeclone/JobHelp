package com.slient.jobhelp.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slient.jobhelp.R
import com.slient.jobhelp.callbacks.QuestionCallback
import com.slient.jobhelp.models.data.LabelGroupQuestion
import com.slient.jobhelp.models.database.data.Question
import kotlinx.android.synthetic.main.item_question.view.*

/**
 * Created by silent on 5/3/2018.
 */
class QuestionAdapter(val callback: QuestionCallback, var questionList: List<Question>? = null) : RecyclerView.Adapter<QuestionAdapter.QuestionHolder>() {

    private lateinit var labelGroupQuestion: LabelGroupQuestion

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return QuestionHolder(view)
    }

    override fun getItemCount(): Int {
        if (questionList == null) {
            return 0
        }
        return questionList!!.size
    }

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        val nowQuestion = questionList!![position]
        holder.bindData(nowQuestion)
    }

    fun swapQuestion(labelGroupQuestion: LabelGroupQuestion, questionList: List<Question>?){
        setLabelGroupQuestion(labelGroupQuestion)
        this.questionList = questionList
        notifyDataSetChanged()
    }

    fun getQuestions(): List<Question>? {
        return questionList
    }

    fun isCheckedAllQuestion(): Boolean{
        questionList?.forEach {
            if (it.point == -1){
                return false
            }
        }
        return true
    }

    fun getTotalPoint(): Int{
        var sum = 0
        questionList?.forEach {
            sum += it.point
        }
        return sum
    }

    fun setLabelGroupQuestion(labelGroupQuestion: LabelGroupQuestion){
        this.labelGroupQuestion = labelGroupQuestion
    }

   fun getLabelGroupQuestion(): LabelGroupQuestion{
       return labelGroupQuestion
   }

    inner class QuestionHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){

        lateinit var question: Question

        init {
            itemView?.radioGroupPoint?.setOnCheckedChangeListener { group, checkedId ->
                question.point = group.indexOfChild(itemView.findViewById(checkedId))
                if(isCheckedAllQuestion()){
                    callback.setEnableForButton(true)
                }
            }
        }

        fun bindData(question: Question) {
            this.question = question
            itemView.questionText.text = question.question
            if(question.point == -1){
                itemView.radioGroupPoint.clearCheck()
            }
        }


    }
}