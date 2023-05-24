package dev.be.awskotlinpractice.controller

import dev.be.awskotlinpractice.dto.KowitRequest
import dev.be.awskotlinpractice.service.KowitService
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.*
import java.net.InetAddress

@Service
@Controller
@RequestMapping("/")
class KowitController(
    private val kowitService: KowitService,
    @Value("\${spring.profiles.active}")
    private val profiles : String,
) {

    @GetMapping
    fun getAll(@PageableDefault(sort = ["createdAt"], direction = Sort.Direction.DESC) pageable: Pageable,
               model : ModelMap) : String {
        val iaddr = InetAddress.getLocalHost()
        val adr = iaddr.hostAddress
        model.addAttribute("dtos", kowitService.getAll(pageable))
        model.addAttribute("ip", adr)
        model.addAttribute("profiles", profiles)
        return "lists"
    }

    @PostMapping
    fun create(request: KowitRequest) : String {
        kowitService.create(request)
        return "redirect:/"
    }

    @PostMapping("/{id}")
    fun delete(@PathVariable id : Long) : String {
        kowitService.delete(id)
        return "redirect:/"
    }

}