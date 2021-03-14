package com.example.jtedemo.jte

import gg.jte.TemplateOutput
import java.io.OutputStream
import java.io.Writer

class OutputStreamTemplateOutput(outputStream: OutputStream) : TemplateOutput {

    private val streamWriter = outputStream.bufferedWriter()

    override fun getWriter(): Writer = streamWriter

    override fun writeContent(value: String?) {
        if (value != null) {
            with(streamWriter) {
                write(value)
                flush()
            }
        }
    }
}