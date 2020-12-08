package day7

const val color = "shiny gold"

typealias ColorMap = Map<String, Map<String, String>>

var amount = 0

val colorMap = data.mapValues { entry ->
    entry.value.replace(Regex(" bag(s)?"), "")
        .split(", ")
        .map {
            val (amount, color) = it.split(" ", limit = 2)
            color to amount
        }
        .toMap()
}

fun contains(color: String, map: ColorMap): Int {
    return map.values
        .filter { it.containsKey(color) || contains(color, it) }
        .count()
}

fun contains(color: String, map: Map<String, String>): Boolean {
    return map.keys
        .filter { colorMap.containsKey(it) }
        .map { colorMap.getValue(it) }
        .filter { it.containsKey(color) || contains(color, it) }
        .count() > 0
}

fun part1() {
    val count = contains(color, colorMap)
    println("Bags found: $count")
}
