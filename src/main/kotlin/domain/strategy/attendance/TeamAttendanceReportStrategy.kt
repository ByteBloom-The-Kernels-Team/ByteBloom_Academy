package domain.strategy.attendance

import domain.model.Attendance
import domain.model.Mentee
import domain.model.MenteeAttendance
import domain.model.Team

interface TeamAttendanceReportStrategy {
    fun generateReport(): Map<String, List<MenteeAttendance>>
}