package day2

fun part1() {
    var correct = 0
    data.forEach { entry ->
        val (amount, letter, password) = entry.split(" ")
        val (min, max) = amount.split("-").map(String::toInt)
        val count = Regex(letter).findAll(password).count()
        val matches = count in min..max

        if (matches) correct++
    }
    println("Correct: $correct")
}

fun part2() {
    val correct = data.map { it.split(" ") }
        .map(::checkPasswordPositions)
        .filter { it == 1 }
        .count()
    println("Correct: $correct")
}

fun checkPasswordPositions(entry: List<String>): Int {
    val (amount, letter, password) = entry
    return amount
        .split("-")
        .map { it.toInt().minus(1) }
        .filter { i -> "${password[i]}" == letter }
        .count()
}
