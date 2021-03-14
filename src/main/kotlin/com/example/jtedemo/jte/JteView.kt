package com.example.jtedemo.jte

import gg.jte.TemplateEngine
import org.springframework.web.servlet.View
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JteView(
    private val templateEngine: TemplateEngine,
    private val templateName: String
) : View {
    override fun render(model: MutableMap<String, *>?, request: HttpServletRequest, response: HttpServletResponse) {
        val modelObject = model?.get(MODEL_OBJECT)
        templateEngine.render(templateName, modelObject, response.templateOutput)
    }

    override fun getContentType(): String = "text/html"
}