package dev.be.awskotlinpractice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class AwsKotlinPracticeApplication

fun main(args: Array<String>) {
    runApplication<AwsKotlinPracticeApplication>(*args)
}
