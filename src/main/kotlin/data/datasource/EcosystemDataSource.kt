package data.datasource

import data.model.AttendanceRaw
import data.model.MenteeRaw
import data.model.PerformanceRaw
import data.model.ProjectRaw
import data.model.TeamRaw

interface EcosystemDataSource {
    fun getTeams(): List<TeamRaw>
    fun getMentees(): List<MenteeRaw>
    fun getAttendance(): List<AttendanceRaw>
    fun getPerformance(): List<PerformanceRaw>
    fun getProjects(): List<ProjectRaw>
}