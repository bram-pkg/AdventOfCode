package day6

fun part1() {
    val count = groups()
        .map {
            it.replace("\n", "")
                .toCharArray()
                .toSet()
                .sorted()
                .joinToString("")
        }
        .map { it.length }
        .sum()
    println("Sum: $count")
}

fun part2() {
    val count = groups()
        .map { entry ->
            val answer = entry.split("\n")
                .joinToString("") {
                    it.toCharArray().toSet().sorted().joinToString("\n")
                }
                .toCharArray().sorted().joinToString("")
            ('a'..'z').sumBy { c ->
                val count = answer.count { it.equals(c) }
                val lines = entry.lines().size
                if (count.equals(lines)) 1 else 0
            }
        }
        .sum()
    println("Sum: $count")
}

private fun groups() = data.split("\n\n")
