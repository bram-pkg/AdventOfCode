fun runSolution(day: Int, part: Int, callback: () -> Unit) {
    println("Day $day, part $part")
    callback.invoke()
    print("\n")
}

fun main() {
    runSolution(1, 1) { day1.part1() }
    runSolution(1, 2) { day1.part2() }
}
