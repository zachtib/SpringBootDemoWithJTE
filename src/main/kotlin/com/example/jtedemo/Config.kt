package com.example.jtedemo

import com.example.jtedemo.jte.JteViewResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import java.nio.file.Path

@Configuration
class Config {
    @Bean
    fun jteViewResolver(): ViewResolver {
        return JteViewResolver(
            templatePath = Path.of("src", "main", "resources", "templates")
        )
    }
}