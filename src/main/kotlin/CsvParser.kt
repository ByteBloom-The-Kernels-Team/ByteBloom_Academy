import models.PerformanceRaw
import models.TeamRaw
import models.MenteeRaw
import java.io.File

val teamFileLines = File("src/main/resources/teams.csv").readLines()
val menteeFileLines = File("src/main/resources/mentees.csv").readLines()
val performanceFileLines = File("src/main/resources/performance.csv").readLines()

fun parseTeamCsvLine(line: String): TeamRaw? {
    val teamParts = line.split(",")
    if (teamParts.size < 3) return null

    return TeamRaw(
        teamParts[0].trim(),
        teamParts[1].trim(),
        teamParts[2].trim()
    )
}

fun parseMenteeCsvLine(line: String): MenteeRaw? {
    val menteeParts = line.split(",")
    if (menteeParts.size < 3) return null

    return MenteeRaw(
        menteeParts[0].trim(),
        menteeParts[1].trim(),
        menteeParts[2].trim()
    )
}

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

fun parseTeamData(): List<TeamRaw> {
    return teamFileLines
        .drop(1)
        .mapNotNull { line -> parseTeamCsvLine(line) }
}

fun parseMenteeData(): List<MenteeRaw> {
    return menteeFileLines
        .drop(1)
        .mapNotNull { line -> parseMenteeCsvLine(line) }
}

fun parsePerformanceData(): List<PerformanceRaw> {
     return performanceFileLines
         .drop(1)
         .mapNotNull { line -> parsePerformanceCsvLine(line) }
}




