package com.slient.jobhelp.models.database.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by silent on 5/2/2018.
 */
@Entity(tableName = "groups")
data class GroupQuestion( @PrimaryKey()
                          @ColumnInfo(name = "id") val id: String,
                          @ColumnInfo(name = "name") val name: String,
                          @ColumnInfo(name = "explanation") val explanation: String)