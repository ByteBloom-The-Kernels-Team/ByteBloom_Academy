package data

import data.models.PerformanceRaw
import data.models.TeamRaw
import data.models.MenteeRaw
import data.models.AttendanceRaw
import data.models.ProjectRaw
import java.io.File

private val teamFileLines = File("src/main/resources/teams.csv").readLines()
private val menteeFileLines = File("src/main/resources/mentees.csv").readLines()
private val performanceFileLines = File("src/main/resources/performance.csv").readLines()
private val attendanceFileLines = File("src/main/resources/attendance.csv").readLines()
private val projectFileLines = File("src/main/resources/project.csv").readLines()

fun validateAndSplit(line: String, expectedSize: Int): List<String>? {
    val parts = line.split(",").map { it.trim() }
    return if (parts.size < expectedSize) null else parts
}

fun parseTeamCsvLine(line: String): TeamRaw? {
    val teamParts = validateAndSplit(line, 3) ?: return null
    return TeamRaw(teamParts[0], teamParts[1], teamParts[2])
}

fun parseTeamData(): List<TeamRaw> {
    return teamFileLines
        .drop(1)
        .mapNotNull { line -> parseTeamCsvLine(line) }
}

fun parseMenteeCsvLine(line: String): MenteeRaw? {
    val menteeParts = validateAndSplit(line, 3) ?: return null
    return MenteeRaw(menteeParts[0], menteeParts[1], menteeParts[2])
}

fun parseMenteeData(): List<MenteeRaw> {
    return menteeFileLines
        .drop(1)
        .mapNotNull { line -> parseMenteeCsvLine(line) }
}

fun parsePerformanceCsvLine(line: String): PerformanceRaw? {
    val performanceParts = validateAndSplit(line, 4) ?: return null
    return PerformanceRaw(performanceParts[0], performanceParts[1], performanceParts[2], performanceParts[3])
}

fun parsePerformanceData(): List<PerformanceRaw> {
    return performanceFileLines
        .drop(1)
        .mapNotNull { line -> parsePerformanceCsvLine(line) }
}
fun parseAttendanceCsvLine(line: String): AttendanceRaw? {
    val attendanceParts = validateAndSplit(line, 4) ?: return null
    return AttendanceRaw(
        attendanceParts[0],
        attendanceParts[1],
        attendanceParts[2],
        attendanceParts[3]
    )
}
fun parseAttendanceData(): List<AttendanceRaw> {
    return attendanceFileLines
        .drop(1)
        .mapNotNull { line -> parseAttendanceCsvLine(line) }
}
fun parseProjectCsvLine(line: String): ProjectRaw? {
    val projectParts = validateAndSplit(line, 3) ?: return null
    return ProjectRaw(
        projectParts[0],
        projectParts[1],
        projectParts[2]
    )
}
fun parseProjectData(): List<ProjectRaw> {
    return projectFileLines
        .drop(1)
        .mapNotNull { line -> parseProjectCsvLine(line) }
}
