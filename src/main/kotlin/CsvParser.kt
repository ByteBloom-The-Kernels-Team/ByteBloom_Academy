import models.MenteeRaw
import java .io.File
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