package com.slient.jobhelp.models.database.data

import android.arch.persistence.room.*

/**
 * Created by silent on 5/2/2018.
 */
@Entity(foreignKeys = arrayOf(ForeignKey(entity = GroupQuestion::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("group-id"),
        onDelete = ForeignKey.CASCADE)))
data class Question(@ColumnInfo(name = "question") val question: String,
                    @ColumnInfo(name = "group-id") val groupId: String){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Long = 0

}