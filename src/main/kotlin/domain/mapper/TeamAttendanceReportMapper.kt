package domain.mapper

import domain.model.Attendance
import domain.model.Mentee
import domain.model.MenteeAttendance

class TeamAttendanceReportMapper(
    private val menteeAttendanceMapper: MenteeAttendanceMapper
) {
    fun map(
        teamMentees: List<Mentee>,
        attendanceByMenteeId: Map<String, Attendance>
    ): List<MenteeAttendance> {
        return teamMentees.map { mentee ->
            menteeAttendanceMapper.map(
                mentee = mentee,
                attendance = attendanceByMenteeId[mentee.id]
            )
        }
    }
}