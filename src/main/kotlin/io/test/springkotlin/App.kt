package io.test.springkotlin

import io.test.springkotlin.services.ImportService
import org.slf4j.LoggerFactory
import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class App(private val importService: ImportService) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(App::class.java)

    override fun run(vararg args: String?) {
        val facts = importService.getRandomFacts()

        log.info("$facts")
    }
}

fun main(args: Array<String>) {
    runApplication<App>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
