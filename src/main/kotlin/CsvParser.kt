import models.TeamRaw
import java.io.File

val csvfiles = File("src/main/resources/teams.csv").readLines()

// This function to parse team data.
fun parseTeamData(): List<TeamRaw>? {

    // Check if the file isExists or not.
    if (!csvfiles.isEmpty()){
        println("This file not exists.")
        return emptyList()
    }

    // Read the file  and data processing.
    return csvfiles.drop(1) // Skip header row
        .map { line ->
            val teamParts = line.split(",")
            if (teamParts.size >= 3) {
                TeamRaw(
                    teamId = teamParts[0].trim(),
                    teamName = teamParts[1].trim(),
                    mentorLead = teamParts[2].trim()
                )
            } else {
                return null
            }
        }
}