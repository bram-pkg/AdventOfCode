package day1

fun part1() {
    data.forEach {
        val min = target - it
        if (data.contains(min)) {
            println("Solution: ${it * min}")
            return@part1
        }
    }
}

fun part2() {
    data.forEach { a ->
        data.forEach { b ->
            if (a == b) return
            val ab = a + b
            if (ab >= target) return
            val min = target - ab
            if (data.contains(min)) {
                println("\tSolution: ${a * b * min}")
                return
            }
        }
    }
}
