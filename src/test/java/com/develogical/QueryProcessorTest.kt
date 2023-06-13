package com.develogical

import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class QueryProcessorTest {
    var queryProcessor = QueryProcessor()

    @Test
    @Throws(Exception::class)
    fun returnsEmptyStringIfCannotProcessQuery() {
        assertThat(queryProcessor.process("test"), `is`(""))
    }

    @Test
    @Throws(Exception::class)
    fun knowsAboutShakespeare() {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"))
    }
}
