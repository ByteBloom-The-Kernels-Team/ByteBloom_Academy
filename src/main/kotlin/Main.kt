
fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    println("✅ Project setup is correct and runnable.")
    println("********************************************")

    println("\n--->>> ByteBloom Ecosystem - Data Parsing Demo <<<---\n")

    val mentees = parseMenteeData()
    println("--->>> Mentee Records Parsed: ${mentees.size}")

    val teams = parseTeamData()
    println("--->>> Team Records Parsed: ${teams.size}")

    val performances = parsePerformanceData()
    println("--->>> Performance Records Parsed: ${performances.size}")

    println("\n--->>> Parsing completed successfully! <<<---")
}