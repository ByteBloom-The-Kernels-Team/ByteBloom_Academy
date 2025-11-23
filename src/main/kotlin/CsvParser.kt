package models
import models.TeamRaw
import java.io.File
val csvMenteeFile  = File("src/main/resources/mentees.csv").readLines()
/**
 * Parses teams.csv file and returns list of TeamRaw objects
 * @return List of TeamRaw objects
 */
fun parseTeamData(): List<TeamRaw> {
    val lines = File("src/main/resources/teams.csv").readLines()
    return lines.drop(1) // Skp header row
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


// This function to parse mentee data.
fun parseMenteeData(): List<MenteeRaw> {
    // Check if the file is exists or not.
    if (!csvMenteeFile.isEmpty()){
        println("This file not exists.")
        return emptyList()
    }
    // Read the file  and data processing.
    return csvMenteeFile.drop(1) // Skip header row
        .map { line ->
            val menteeParts =
                line.split(",")
            if (menteeparts.size >= 3){
                MenteeRaw(
                    Id = parts[0].trim(),
                    Name = parts[1].trim(),
                    teamId = parts[2].trim()
                )
            } else {
                return null
            }
        }
}
