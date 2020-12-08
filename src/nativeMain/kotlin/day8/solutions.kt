package day8

fun part1() {
    val executed = mutableSetOf<Int>()
    var accumulator = 0
    var i = 0
    while (i < data.size) {
        if (executed.contains(i)) break
        executed.add(i)

        val (instruction, valueString) = data[i].split(" ")
        val value = valueString.toIntOrNull() ?: 0
        when (instruction) {
            "jmp" -> i += value
            "acc" -> {
                accumulator += value
                i++
            }
            "nop" -> i++
        }
        println("$instruction:$value\t$$i:$accumulator")
    }
    println(accumulator)
}

fun part2() {
    var accumulator = 0
    var i = 0
    while (i < data.size) {
        val (instruction, valueString) = data[i].split(" ")
        val value = valueString.toIntOrNull() ?: 0
        when (instruction) {
            "jmp" -> i += value
            "acc" -> {
                accumulator += value
                i++
            }
            "nop" -> i++
        }
        println("$instruction:$value\t$$i:$accumulator")
    }
    println(accumulator)
}
