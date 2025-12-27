package repository

import models.TeamRaw
import models.MenteeRaw
import models.AttendanceRaw
import models.PerformanceRaw
import models.ProjectRaw

interface EcosystemDataSource {
    fun getTeamsRaw(): List<TeamRaw>
    fun getMenteesRaw(): List<MenteeRaw>
    fun getAttendanceRaw(): List<AttendanceRaw>
    fun getPerformanceRaw(): List<PerformanceRaw>
    fun getProjectsRaw(): List<ProjectRaw>
}
