package data.datasource

import data.models.AttendanceRaw
import data.models.MenteeRaw
import data.models.PerformanceRaw
import data.models.ProjectRaw
import data.models.TeamRaw

interface EcosystemDataSource {
    fun getTeamsRaw(): List<TeamRaw>
    fun getMenteesRaw(): List<MenteeRaw>
    fun getAttendanceRaw(): List<AttendanceRaw>
    fun getPerformanceRaw(): List<PerformanceRaw>
    fun getProjectsRaw(): List<ProjectRaw>
}