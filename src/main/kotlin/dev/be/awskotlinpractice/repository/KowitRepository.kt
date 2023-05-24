package dev.be.awskotlinpractice.repository

import dev.be.awskotlinpractice.domain.Kowit
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface KowitRepository : JpaRepository<Kowit, Long> {

    override fun findAll(pageable: Pageable) : Page<Kowit>

}