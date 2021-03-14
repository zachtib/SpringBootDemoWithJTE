package com.example.jtedemo.jte

import gg.jte.ContentType
import gg.jte.TemplateEngine
import gg.jte.resolve.DirectoryCodeResolver
import org.springframework.web.servlet.View
import org.springframework.web.servlet.ViewResolver
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

class JteViewResolver(templatePath: Path, private val templateExtension: String = "") : ViewResolver {
    private val codeResolver: DirectoryCodeResolver = DirectoryCodeResolver(templatePath)
    private val templateEngine: TemplateEngine = TemplateEngine.create(
        codeResolver,
        Paths.get("jte-classes"),
        ContentType.Html,
        javaClass.classLoader
    )

    override fun resolveViewName(viewName: String, locale: Locale): View? {
        val fullViewName = "$viewName$templateExtension"
        val filename: String? = codeResolver.resolve(fullViewName)
        return if (filename != null) {
            JteView(templateEngine, fullViewName)
        } else {
            null
        }
    }
}