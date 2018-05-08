package com.slient.jobhelp.models.database.dao

import android.arch.persistence.room.*
import com.slient.jobhelp.models.database.data.GroupQuestion
import com.slient.jobhelp.models.database.data.Question

/**
 * Created by silent on 5/2/2018.
 */
@Dao
interface GroupQuestionDAO {

    @Query("select * from groups")
    fun getAllGroup(): List<GroupQuestion>

    @Query("select * from groups where groups.id == :id")
    fun getGroupQuestionFollowId(id: String): GroupQuestion

    @Insert
    fun insert(groupQuestions: List<GroupQuestion>)

    @Update
    fun update(groupQuestion: GroupQuestion)

    @Delete
    fun delete(groupQuestion: GroupQuestion)
}