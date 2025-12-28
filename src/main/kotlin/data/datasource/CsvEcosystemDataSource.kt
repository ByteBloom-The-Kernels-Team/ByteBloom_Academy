package data.datasource

import parseAttendanceData
import parseMenteeData
import parsePerformanceData
import parseProjectData
import parseTeamData

class CsvEcosystemDataSource : EcosystemDataSource {
    override fun getTeamsRaw() = parseTeamData()
    override fun getMenteesRaw() = parseMenteeData()
    override fun getAttendanceRaw() = parseAttendanceData()
    override fun getPerformanceRaw() = parsePerformanceData()
    override fun getProjectsRaw() = parseProjectData()
}