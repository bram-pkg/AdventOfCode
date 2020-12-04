package day4

typealias StringMap = Map<String, String>

fun List<StringMap>.filterRegex(key: String, regex: Regex) =
    this.filter { validateMapRegex(key, it, regex) }

fun List<StringMap>.filterIntRange(key: String, min: Int, max: Int) =
    this.filter { validateIntRange(key, it, min, max) }

/**
 * Check if a given key, in a map, passes the given predicate
 */
fun <V, M : Map<String, V>> validate(key: String, map: M, predicate: (V) -> Boolean): Boolean {
    val value = map[key] ?: return false
    return predicate.invoke(value)
}

/**
 * Check if a given key, in a map, matches a <code>Regex</code>
 */
fun <M : StringMap> validateMapRegex(key: String, map: M, regex: Regex) =
    validate(key, map) { return@validate it.matches(regex) }


/**
 * Check if a given key, in a map, when converted to an int, falls in the range <code>min..max</code>.
 */
fun <M : StringMap> validateIntRange(key: String, map: M, min: Int, max: Int) =
    validate(key, map) {
        val int = it.toIntOrNull() ?: return@validate false
        return@validate it.length.equals(4) && int in min..max
    }

fun <M : StringMap> validateHeight(key: String, map: M) = validate(key, map) { value ->
    if (value.endsWith("cm")) {
        val (height) = value.split("cm").map { it.toIntOrNull() }
        return@validate height in 150..193
    }
    if (value.endsWith("in")) {
        val (height) = value.split("in").map { it.toIntOrNull() }
        return@validate height in 59..76
    }
    false
}
