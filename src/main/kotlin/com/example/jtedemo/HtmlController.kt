package com.example.jtedemo

import com.example.jtedemo.jte.render
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

data class HelloModel(val title: String, val message: String)

@Controller
class HtmlController {
    @GetMapping("/")
    fun hello(model: Model): String {
        val result = HelloModel(
            title = "Hello, World",
            message = "Hello from JTE"
        )
        return model.render("hello.kte", result)
    }
}