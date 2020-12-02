import kotlin.time.ExperimentalTime

@ExperimentalTime
fun runSolution(day: Int, part: Int, callback: () -> Unit) {
    print("Running: day $day, part $part\n---\n")
    val duration = kotlin.time.measureTime(callback)
    print("---\nFinished: day $day, part $part in ${duration.inNanoseconds}µs\n\n")
}

@ExperimentalTime
fun main() {
//    runSolution(1, 1) { day1.part1() }
//    runSolution(1, 2) { day1.part2() }
//
//    runSolution(2, 1) { day2.part1() }
    runSolution(2, 2) { day2.part2() }
}
