package domain.strategy.attendance

import domain.model.Attendance
import domain.model.Mentee
import domain.model.MenteeAttendance
import domain.model.Team

interface TeamAttendanceReportStrategy {
    fun generateReport(
        teams: List<Team>,
        mentees: List<Mentee>,
        attendances: List<Attendance>
    ): Map<String, List<MenteeAttendance>>
}