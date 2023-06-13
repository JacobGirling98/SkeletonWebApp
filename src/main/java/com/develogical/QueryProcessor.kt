package com.develogical

import java.util.*

class QueryProcessor {
    fun process(query: String): String {
        println("Received query:$query")

        if (query.lowercase(Locale.getDefault()).contains("shakespeare")) {
            return ("William Shakespeare (26 April 1564 - 23 April 1616) was an "
                    + "English poet, playwright, and actor, widely regarded as the greatest "
                    + "writer in the English language and the world's pre-eminent dramatist.")
        } else return ""






    }
}
