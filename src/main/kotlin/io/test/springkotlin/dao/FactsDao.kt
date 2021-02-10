package io.test.springkotlin.dao

import io.test.springkotlin.models.AnimalFact
import org.springframework.stereotype.Component

@Component
interface FactsDao {

    fun save(animalFact: AnimalFact)

    fun getFacts(): List<AnimalFact>

}