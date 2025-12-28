package Strategy.Attendance

import Service.MenteeAttendance
import domain.Attendance
import domain.Mentee
import domain.Team

interface TeamAttendanceReportStrategy {
    fun generateReport(
        teams: List<Team>,
        mentees: List<Mentee>,
        attendances: List<Attendance>
    ): Map<String, List<MenteeAttendance>>
}