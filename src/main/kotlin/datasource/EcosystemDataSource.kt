package datasource

import models.AttendanceRaw
import models.MenteeRaw
import models.PerformanceRaw
import models.ProjectRaw
import models.TeamRaw

interface EcosystemDataSource {
    fun getTeamsRaw(): List<TeamRaw>
    fun getMenteesRaw(): List<MenteeRaw>
    fun getAttendanceRaw(): List<AttendanceRaw>
    fun getPerformanceRaw(): List<PerformanceRaw>
    fun getProjectsRaw(): List<ProjectRaw>
}