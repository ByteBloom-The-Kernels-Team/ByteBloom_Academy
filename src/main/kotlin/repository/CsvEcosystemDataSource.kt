package repository

import parseTeamData
import parseMenteeData
import parseAttendanceData
import parsePerformanceData
import parseProjectData

class CsvEcosystemDataSource : EcosystemDataSource {
    override fun getTeamsRaw() = parseTeamData()
    override fun getMenteesRaw() = parseMenteeData()
    override fun getAttendanceRaw() = parseAttendanceData()
    override fun getPerformanceRaw() = parsePerformanceData()
    override fun getProjectsRaw() = parseProjectData()
}
