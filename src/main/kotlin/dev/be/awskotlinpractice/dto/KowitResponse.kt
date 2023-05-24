package dev.be.awskotlinpractice.dto

import dev.be.awskotlinpractice.domain.Kowit
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class KowitResponse(
    val id : Long,
    val description : String,
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt : LocalDateTime?,
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val modifiedAt: LocalDateTime?
) {

    companion object {

        operator fun invoke(kowit : Kowit) =
            with(kowit) {
                KowitResponse(
                    id = id!!,
                    description = description,
                    createdAt = createdAt,
                    modifiedAt = modifiedAt
                )
            }

    }

}