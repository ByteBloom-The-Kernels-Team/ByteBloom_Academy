package data.datasource

import data.dto.AttendanceRaw
import data.dto.MenteeRaw
import data.dto.PerformanceRaw
import data.dto.ProjectRaw
import data.dto.TeamRaw

interface EcosystemDataSource {
    fun getTeamsRaw(): List<TeamRaw>
    fun getMenteesRaw(): List<MenteeRaw>
    fun getAttendanceRaw(): List<AttendanceRaw>
    fun getPerformanceRaw(): List<PerformanceRaw>
    fun getProjectsRaw(): List<ProjectRaw>
}