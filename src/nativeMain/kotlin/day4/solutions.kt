package day4

fun part1() {
    val valid = passports()
        .asSequence()
        .filter {
            it.containsKey("byr")
                    && it.containsKey("iyr")
                    && it.containsKey("eyr")
                    && it.containsKey("hgt")
                    && it.containsKey("hcl")
                    && it.containsKey("ecl")
                    && it.containsKey("pid")
        }
        .count()
    println("Valid passports: $valid")
}

fun part2() {
    val valid = passports()
        .filterIntRange("byr", 1920, 2002)
        .filterIntRange("iyr", 2010, 2020)
        .filterIntRange("eyr", 2020, 2030)
        .filter { validateHeight("hgt", it) }
        .filterRegex("hcl", Regex("^#[a-z0-9]{6}$"))
        .filter { validate("ecl", it) { v -> listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(v) } }
        .filterRegex("pid", Regex("^[0-9]{9}$"))
        .count()
    println("Valid passports: $valid")
}
