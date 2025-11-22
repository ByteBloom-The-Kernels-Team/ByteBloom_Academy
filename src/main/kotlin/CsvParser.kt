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
 * Parses mentees.csv file and returns list of MenteeRaw objects
 * @return List of MenteeRaw objects
 */

fun parseMenteeData(): List<MenteeRaw> {
    val lines = File("src/main/resources/mentees.csv").readLines()
    return lines.drop(1) // Skip header row
        .mapNotNull { line ->
            val parts = line.split(",")
            if (parts.size >= 3) {
                val (id, name, team) = parts.map { it.trim() }
                MenteeRaw(id, name, team)
            } else {
                null // Skip invalid rows
            }
        }
}
