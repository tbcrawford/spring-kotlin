package io.test.springkotlin.client

import io.test.springkotlin.models.AnimalFact
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "cat-facts-api", url = "https://cat-fact.herokuapp.com")
interface CatFactsClient {

    @GetMapping("/facts/random?animal_type={animalType}&amount={amount}")
    fun getRandomFactsBy(@PathVariable animalType: String, @PathVariable amount: Int): List<AnimalFact>

    @GetMapping("/facts/random")
    fun getRandomFacts(): List<AnimalFact>
}