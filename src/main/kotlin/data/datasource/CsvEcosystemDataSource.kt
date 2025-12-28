package data.datasource

import data.parseAttendanceData
import data.parseMenteeData
import data.parsePerformanceData
import data.parseProjectData
import data.parseTeamData

class CsvEcosystemDataSource : EcosystemDataSource {
    override fun getTeamsRaw() = parseTeamData()
    override fun getMenteesRaw() = parseMenteeData()
    override fun getAttendanceRaw() = parseAttendanceData()
    override fun getPerformanceRaw() = parsePerformanceData()
    override fun getProjectsRaw() = parseProjectData()
}