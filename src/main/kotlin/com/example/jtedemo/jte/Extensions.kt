package com.example.jtedemo.jte

import gg.jte.TemplateOutput
import gg.jte.output.PrintWriterOutput
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletResponse

const val MODEL_OBJECT = "modelObject"
const val MODEL_CLASS = "modelClass"

/**
 * Convenience method in order to create a [ModelAndView] instance for rendering with JTE.
 *
 * This creates a [ModelAndView] instance, and sets the viewName property to [viewName], and
 * then stores both [responseModel] as well as its class onto the Model component of [ModelAndView].
 *
 * [JteViewResolver] will later unload [responseModel] before handing it off for rendering.
 *
 * @param viewName: The name of the View to render
 * @param responseModel: An instance of the model class that View is expecting as a parameter
 * @return: A [ModelAndView] instance populated such that [JteViewResolver] will understand it
 */
inline fun <reified T : Any> modelAndViewOf(viewName: String, responseModel: T): ModelAndView {
    val mv = ModelAndView()
    mv.viewName = viewName
    mv.model[MODEL_OBJECT] = responseModel
    mv.model[MODEL_CLASS] = T::class
    return mv
}

val HttpServletResponse.templateOutput: TemplateOutput
    get() = PrintWriterOutput(writer)