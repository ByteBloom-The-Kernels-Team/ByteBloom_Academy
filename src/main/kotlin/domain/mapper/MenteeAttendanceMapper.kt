package domain.mapper

import domain.model.Attendance
import domain.model.AttendanceStatus
import domain.model.Mentee
import domain.model.MenteeAttendance

class MenteeAttendanceMapper {
    fun map(
        mentee: Mentee,
        attendance: Attendance?
    ): MenteeAttendance {
        return MenteeAttendance(
            menteeName = mentee.name,
            weekStatuses = attendance?.weeklyStatus ?: emptyList()
        )
    }
}