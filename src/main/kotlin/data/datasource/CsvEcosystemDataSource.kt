package data.datasource

import data.parseAttendanceData
import data.parseMenteeData
import data.parsePerformanceData
import data.parseProjectData
import data.parseTeamData

class CsvEcosystemDataSource : EcosystemDataSource {
    override fun getTeams() = parseTeamData()
    override fun getMentees() = parseMenteeData()
    override fun getAttendance() = parseAttendanceData()
    override fun getPerformance() = parsePerformanceData()
    override fun getProjects() = parseProjectData()
}