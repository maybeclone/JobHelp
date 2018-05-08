package com.slient.jobhelp.adapters

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slient.jobhelp.R
import com.slient.jobhelp.models.database.data.GroupQuestion
import kotlinx.android.synthetic.main.item_explanation_group.view.*

/**
 * Created by silent on 5/4/2018.
 */
class GroupAdapter(var groupQuestions: ArrayList<GroupQuestion>? = null) : RecyclerView.Adapter<GroupAdapter.GroupHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explanation_group, parent, false)
        return GroupHolder(view)
    }

    override fun getItemCount(): Int {
        if (groupQuestions == null)
            return 0
        return groupQuestions!!.size
    }

    override fun onBindViewHolder(holder: GroupHolder, position: Int) {
        val groupQuestion = groupQuestions!![position]
        holder.bindData(groupQuestion)
    }

    fun swapList(groupQuestions: ArrayList<GroupQuestion>?){
        this.groupQuestions = groupQuestions
        notifyDataSetChanged()
    }

    inner class GroupHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(groupQuestion: GroupQuestion) {
            itemView.nameText.setText(groupQuestion.name)
            itemView.explainText.setText(groupQuestion.explanation)
            when (groupQuestion.id) {
                "A" -> {
                    itemView.descriptionImageView.setImageResource(R.drawable.realistic_group)
                    itemView.groupCardView.setCardBackgroundColor(itemView.context.resources.getColor(R.color.colorRealisticGroup))
                }
                "B" -> {
                    itemView.descriptionImageView.setImageResource(R.drawable.investigative_group)
                    itemView.groupCardView.setCardBackgroundColor(itemView.context.resources.getColor(R.color.colorInvestigativeGroup))
                }
                "C" -> {
                    itemView.descriptionImageView.setImageResource(R.drawable.artistic_group)
                    itemView.groupCardView.setCardBackgroundColor(itemView.context.resources.getColor(R.color.colorArtisticGroup))
                }
                "D" -> {
                    itemView.descriptionImageView.setImageResource(R.drawable.social_group)
                    itemView.groupCardView.setCardBackgroundColor(itemView.context.resources.getColor(R.color.colorSocialGroup))
                }
                "E" -> {
                    itemView.descriptionImageView.setImageResource(R.drawable.enterprising_group)
                    itemView.groupCardView.setCardBackgroundColor(itemView.context.resources.getColor(R.color.colorEnterprisingGroup))
                }
                "F" -> {
                    itemView.descriptionImageView.setImageResource(R.drawable.conventional_group)
                    itemView.groupCardView.setCardBackgroundColor(itemView.context.resources.getColor(R.color.colorConventionalGroup))
                }

            }
        }

    }
}