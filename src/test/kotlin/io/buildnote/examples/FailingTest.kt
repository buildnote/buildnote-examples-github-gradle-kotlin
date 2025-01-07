package io.buildnote.examples

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FailingTest {

    @Test
    fun `test fails with exception`() {
        throw IllegalArgumentException("Invalid exception in test")
    }

    @Test
    fun `test fails with assertion`() {
        Assertions.assertEquals("this", "that")
    }

}
