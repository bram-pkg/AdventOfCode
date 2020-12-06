package day5

import kotlin.math.ceil

const val rows = 127
const val seats = 7

fun part1() {
    val max = seatIdList().maxOrNull()
    println("Maximum seat ID: $max")
}

fun part2() {
    val idList = seatIdList()
    for (i in 0..128 * 8) {
        val id = calc(i / 8, i % 8)
        val neighbourIdList = listOf(i - 1, i + 1).map { calc(it / 8, it % 8) }
        if (!idList.contains(id) && idList.containsAll(neighbourIdList)) {
            println("Your seat ID: $id")
        }
    }
}

fun seatIdList() = data.map {
    val rowCode = it.substring(0..6)
    val seatCode = it.substring(7)
    val row = walk(rowCode, rows, 'F', 'B')
    val seat = walk(seatCode, seats, 'L', 'R')
    calc(row, seat)
}

fun calc(row: Int, seat: Int) = row * 8 + seat

fun walk(code: String, length: Int, lower: Char, upper: Char): Int {
    var range = 0..length
    code.forEach {
        if (it in setOf(lower, upper)) {
            range = range.first..ceil(range.last.toDouble().div(2)).toInt()
        }
        if (it == upper) {
            range = range.first + range.last..range.last
        }
    }
    if (range.last != 1) {
        throw Throwable("range should be only 1 in length")
    }
    return range.first
}
