package io.test.springkotlin.models

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class AnimalFact(
    @JsonProperty("_id") val id: String?,
    val text: String?,
    val updatedAt: LocalDateTime?,
    val deleted: Boolean?,
    val source: String?,
    val sentCount: Int?
)
