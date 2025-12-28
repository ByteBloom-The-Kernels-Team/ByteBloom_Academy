package domain.strategy.attendance

import service.MenteeAttendance
import domain.module.Attendance
import domain.module.Mentee
import domain.module.Team

interface TeamAttendanceReportStrategy {
    fun generateReport(
        teams: List<Team>,
        mentees: List<Mentee>,
        attendances: List<Attendance>
    ): Map<String, List<MenteeAttendance>>
}