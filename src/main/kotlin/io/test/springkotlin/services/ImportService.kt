package io.test.springkotlin.services

import io.test.springkotlin.client.CatFactsClient
import io.test.springkotlin.dao.FactsDao
import io.test.springkotlin.models.AnimalFact
import io.test.springkotlin.models.Person
import org.springframework.stereotype.Service

interface ImportService {
    fun getData(): List<Person>
    fun getRandomFacts(): List<AnimalFact>
}

@Service
class DefaultImportService(
    private val catFactsClient: CatFactsClient,
    private val factsDao: FactsDao
) : ImportService {

    override fun getData(): List<Person> {
        return listOf(
            Person("Tyler", 27),
            Person("Miranda", 27)
        )
    }

    override fun getRandomFacts(): List<AnimalFact> {
        val randomFacts = catFactsClient.getRandomFactsBy("cat", 3)
        randomFacts.forEach(factsDao::save)

        return factsDao.getFacts()
    }

}