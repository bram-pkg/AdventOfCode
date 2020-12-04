package day3

fun part1() {
    var column = 0
    var total = 0
    data.forEach {
        if (it[column % it.length] == '#') {
            total++
        }
        column += 3
    }
    println("Total trees: $total")
}

fun part2() {
    val steps = listOf(
        "1,1",
        "3,1",
        "5,1",
        "7,1",
        "1,2",
    )

    val total = steps.map {
        var row = 0
        var column = 0
        var trees = 0
        while (row < data.size) {
            val (x, y) = it.split(",").map(String::toInt)
            val rowValue = data[row]
            val char = rowValue[column % rowValue.length]
            if (char == '#') {
                trees++
            }
            row += y
            column += x
        }
        trees
    }.reduce { a: Int, b: Int -> a * b }

    println("Trees encountered: $total")
}
