package com.angel.practica3

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NoticiaEntity")
data class NoticiaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var titulo: String,
    var resumen: String,
    var fecha: String,
    var imagenDePortada: String,
    var url: String
    )



