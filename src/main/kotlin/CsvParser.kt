
// Parser functions for reading CSV files and converting to data objects

import models.PerformanceRaw
import models.TeamRaw
import models.MenteeRaw
import java.io.File

// Constants: read CSV files once
val teamFileLines = File("src/main/resources/teams.csv").readLines()
val menteeFileLines = File("src/main/resources/mentees.csv").readLines()
val performanceFileLines = File("src/main/resources/performance.csv").readLines()



// Convert one CSV line into TeamRaw
fun parseTeamCsvLine(line: String): TeamRaw? {
    val teamParts = line.split(",")
    if (teamParts.size < 3) return null

    return TeamRaw(
        teamParts[0].trim(),
        teamParts[1].trim(),
        teamParts[2].trim()
    )
}

// Convert one CSV line into MenteeRaw
fun parseMenteeCsvLine(line: String): MenteeRaw? {
    val menteeParts = line.split(",")
    if (menteeParts.size < 3) return null

    return MenteeRaw(
        menteeParts[0].trim(),
        menteeParts[1].trim(),
        menteeParts[2].trim()
    )
}

// Convert one CSV line into PerformanceRaw
fun parsePerformanceCsvLine(line: String): PerformanceRaw? {
    val performanceParts = line.split(",")
    if (performanceParts.size < 4) return null

    return PerformanceRaw(
        performanceParts[0].trim(),
        performanceParts[1].trim(),
        performanceParts[2].trim(),
        performanceParts[3].trim()
    )
}

// Parse team data from teams.csv
fun parseTeamData(): List<TeamRaw> {
    return teamFileLines
        .drop(1)
        .mapNotNull { line -> parseTeamCsvLine(line) }
}


// Parse mentee data from teams csv
fun parseMenteeData(): List<MenteeRaw> {
    return menteeFileLines
        .drop(1)
        .mapNotNull { line -> parseMenteeCsvLine(line) }
}



 // Parse performance data from performance.csv
 fun parsePerformanceData(): List<PerformanceRaw> {
     return performanceFileLines
         .drop(1)
         .mapNotNull { line -> parsePerformanceCsvLine(line) }
 }




