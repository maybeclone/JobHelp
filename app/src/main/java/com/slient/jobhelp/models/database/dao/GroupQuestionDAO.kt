package com.slient.jobhelp.models.database.dao

import android.arch.persistence.room.*
import com.slient.jobhelp.models.database.data.GroupQuestion

/**
 * Created by silent on 5/2/2018.
 */
@Dao
interface GroupQuestionDAO {

    @Query("select * from groups")
    fun getAllGroup(): List<GroupQuestion>

    @Insert
    fun insert(groupQuestions: List<GroupQuestion>)

    @Update
    fun update(groupQuestion: GroupQuestion)

    @Delete
    fun delete(groupQuestion: GroupQuestion)
}