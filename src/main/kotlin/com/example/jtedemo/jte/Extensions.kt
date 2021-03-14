package com.example.jtedemo.jte

import gg.jte.TemplateOutput
import org.springframework.ui.Model
import org.springframework.ui.set
import javax.servlet.http.HttpServletResponse

const val MODEL_OBJECT = "modelObject"
const val MODEL_CLASS = "modelClass"

inline fun <reified T : Any> Model.render(templateName: String, responseModel: T): String {
    this[MODEL_OBJECT] = responseModel
    this[MODEL_CLASS] = T::class
    return templateName
}

val HttpServletResponse.templateOutput: TemplateOutput
    get() = OutputStreamTemplateOutput(this.outputStream)