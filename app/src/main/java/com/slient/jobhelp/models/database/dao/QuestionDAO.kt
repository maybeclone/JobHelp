package com.slient.jobhelp.models.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.slient.jobhelp.models.database.data.GroupQuestion
import com.slient.jobhelp.models.database.data.Question

/**
 * Created by silent on 5/2/2018.
 */
@Dao
interface QuestionDAO {

    @Query("select * from question where question.`group-id` == :groupId")
    fun getQuestionFollowGroup(groupId: String): List<Question>

    @Insert
    fun insert(questions: List<Question>)



}