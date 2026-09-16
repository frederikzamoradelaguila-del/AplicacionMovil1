package com.example.aplicacion.model

import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val isCompleted: Boolean = false
)