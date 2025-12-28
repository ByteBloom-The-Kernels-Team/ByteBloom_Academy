package domain.strategy.attendance

import domain.models.Attendance
import domain.models.Mentee
import domain.models.Team

interface TeamAttendanceReportStrategy {
    fun generateReport(
        teams: List<Team>,
        mentees: List<Mentee>,
        attendances: List<Attendance>
    ): Map<String, List<MenteeAttendance>>
}