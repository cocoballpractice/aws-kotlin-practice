package dev.be.awskotlinpractice.service

import dev.be.awskotlinpractice.domain.Kowit
import dev.be.awskotlinpractice.dto.KowitRequest
import dev.be.awskotlinpractice.dto.KowitResponse
import dev.be.awskotlinpractice.repository.KowitRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class KowitService(
    private val kowitRepository: KowitRepository,
) {

    @Transactional(readOnly = true)
    fun getAll(pageable: Pageable) =
        kowitRepository.findAll(pageable)?.map { KowitResponse(it) }


    fun create(request : KowitRequest) = kowitRepository.save(Kowit(description = request.description))


    fun delete(id : Long) = kowitRepository.deleteById(id)


}