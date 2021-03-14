package com.example.jtedemo.jte

import gg.jte.TemplateOutput
import java.io.OutputStream
import java.io.Writer

class OutputStreamTemplateOutput(private val outputStream: OutputStream) : TemplateOutput {
    override fun getWriter(): Writer = outputStream.writer()

    override fun writeContent(value: String?) {
        if (value != null) {
            writer.write(value)
        }
    }
}