package models
import models.TeamRaw
import java.io.File

/**
 * Parses teams.csv file and returns list of TeamRaw objects
 * @return List of TeamRaw objects
 */
fun parseTeamData(): List<TeamRaw> {
    val lines = File("src/main/resources/teams.csv").readLines()
    return lines.drop(1) // Skip header row
        .mapNotNull { lines ->
            val parts = lines.split(",")
            if (parts.size >= 3) {
                TeamRaw(
                    teamId = parts[0].trim(),
                    teamName = parts[1].trim(),
                    mentorLead = parts[2].trim()
                )
            } else {
                null // Skip invalid rows
            }
        }
}



/**
 * Parser functions for reading CSV files and converting to data objects
 */


/**
 * Parses performance.csv file and returns list of PerformanceRaw objects
 * @return List of PerformanceRaw objects
 */
fun parsePerformanceData(): List<PerformanceRaw> {
    val lines = File("src/main/resources/performance.csv").readLines()
    return lines.drop(1) // Skip header row
        .mapNotNull { line ->
            val parts = line.split(",")
            if (parts.size >= 4) {
                PerformanceRaw(
                    menteeId = parts[0].trim(),
                    submissionId = parts[1].trim(),
                    submissionType = parts[2].trim(),
                    score = parts[3].trim() // Keep as String per requirements
                )
            } else {
                null // Skip invalid rows
            }
        }
}