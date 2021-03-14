package com.example.jtedemo.jte

import gg.jte.TemplateOutput
import gg.jte.output.PrintWriterOutput
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletResponse

const val MODEL_OBJECT = "modelObject"
const val MODEL_CLASS = "modelClass"

inline fun <reified T : Any> render(viewName: String, responseModel: T): ModelAndView {
    val mv = ModelAndView()
    mv.viewName = viewName
    mv.model[MODEL_OBJECT] = responseModel
    mv.model[MODEL_CLASS] = T::class
    return mv
}

val HttpServletResponse.templateOutput: TemplateOutput
    get() = PrintWriterOutput(writer)