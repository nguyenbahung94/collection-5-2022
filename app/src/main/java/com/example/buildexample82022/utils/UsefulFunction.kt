package com.example.buildexample82022.utils

class UsefulFunction {
    private var stocks = "test stocks"
    fun testJoinToString() {
        val builder = StringBuilder()
        builder.append("[")
        for (i in stocks.indices) {
            builder.append(stocks[i])
            if (i == stocks.length - 1) {
                builder.append(", ")
            }
        }
        builder.append("]")
        /*
        result = "[test stocks]" can replace it by function below
        * */
        stocks.toCharArray().joinToString(prefix = "[", postfix = "]")
        /*
        document joinToString
        https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/join-to-string.html
        * */
    }
}