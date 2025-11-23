/**
 * Main entry point for the ByteBloom Ecosystem application
 * Demonstrates parsing CSV files and counting records
 */
fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    println("✅ Project setup is correct and runnable.")
    println("********************************************")

    println("\n--->>> ByteBloom Ecosystem - Data Parsing Demo <<<---\n")

    // Parse and display mentee data
    val mentees = parseMenteeData()
    println("--->>> Mentee Records Parsed: ${mentees.size}")

    // Parse and display team data
    val teams = parseTeamData()
    println("--->>> Team Records Parsed: ${teams.size}")

    // Parse and display performance data
    val performances = parsePerformanceData()
    println("--->>> Performance Records Parsed: ${performances.size}")

    println("\n--->>> Parsing completed successfully! <<<---")
}