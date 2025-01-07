package io.buildnote.examples

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import strikt.api.expectThat
import strikt.assertions.isNotBlank

class LotOfResultsTest {

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("getData")
    fun `should generate lot of results`(input: String) {
        println("Some text to print out to output for test \"$input\"")
        expectThat(input).isNotBlank()
    }

    companion object {
        @JvmStatic
        fun getData() = (0.. 50).map { i -> "Should generate result for this load test $i" }
    }

}