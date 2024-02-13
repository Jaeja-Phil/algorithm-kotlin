package educative.decode_the_coding_interview_in_kotlin.netflix

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    fun groupTitles(titles: Array<String>): List<List<String>> {
        // early return when title is empty
        if (titles.isEmpty()) {
            return emptyList()
        }

        val map = mutableMapOf<String, MutableList<String>>()
        val alphabetCountArray = IntArray(26)
        for (title in titles) {
            Arrays.fill(alphabetCountArray, 0)
            for (c in title) {
                alphabetCountArray[c - 'a']++
            }
            val key = alphabetCountArray.joinToString("@")
            if (!map.containsKey(key)) {
                map[key] = mutableListOf()
            }
            map[key]?.add(title)
        }

        return ArrayList<List<String>>(map.values)
    }

    val titles = arrayOf("duel", "dule", "speed", "spede", "deul", "cars")
    val gt: List<List<String>> = groupTitles(titles)

    val query = "spede"
    for (g in gt) {
        if (g.contains(query)) {
            println(g)
        }
    }
}
