package day3

fun part1() {
    var column = 0
    var total = 0
    data.forEach {
        if (it[column] == '#') {
            total++
        }
        column += 3
    }
    println("Total trees: $total")
}