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

    /*
    * groupBy()
         groupBy() is used to group elements of a collection according to a category
          it returns a map of categories as key and a list as value.
    * */

    fun testGroupBy() {
        // without groupBy()

        val mapByCategory = HashMap<String, List<Stock>>()
        val stocks = mutableListOf<Stock>()
        val gainers = mutableListOf<Stock>()
        val losers = mutableListOf<Stock>()
        for (i in 0 until stocks.size) {
            if (stocks[i].gainedToday) {
                gainers.add(stocks[i])
            } else {
                losers.add(stocks[i])
            }
        }
        mapByCategory["gainers"] = gainers
        mapByCategory["losers"] = losers
        // return map
        // with groupBy()

        val mapbyCategory = stocks.groupBy { if (it.gainedToday) "gainers" else "losers" }
    }

    /*
    subtract()
    subtract() is used to get the elements which are present in this collection but not present in other.
    * */

}

data class Stock(
    val name: String,
    val gainedToday: Boolean,
)