package domain.strategy.attendance

import domain.model.Attendance

class AttendanceIndex {
    fun index(attendances: List<Attendance>): Map<String, Attendance> =
        attendances.associateBy { it.menteeId }
}