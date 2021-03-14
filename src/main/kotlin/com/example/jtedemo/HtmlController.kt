package com.example.jtedemo

import com.example.jtedemo.jte.modelAndViewOf
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

data class HelloModel(val title: String, val message: String)

@Controller
class HtmlController {
    @GetMapping("/")
    fun hello(): ModelAndView {
        val result = HelloModel(
            title = "Hello, World",
            message = "Hello from JTE"
        )
        return modelAndViewOf("hello", result)
    }
}