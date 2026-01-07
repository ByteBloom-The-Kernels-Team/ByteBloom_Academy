package domain.filter

import domain.model.Attendance

class AttendanceByMenteeFilter {
    fun filterByMentee(
        menteeId: String,
        attendances: List<Attendance>
    ): Attendance? {
        return attendances.firstOrNull { it.menteeId == menteeId }
    }
}