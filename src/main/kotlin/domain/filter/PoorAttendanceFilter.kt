package domain.filter

import domain.model.Attendance
import domain.model.AttendanceStatus

class PoorAttendanceFilter {
    fun filter(
        attendances: List<Attendance>
    ): List<Attendance> {
        return attendances.filter {
            it.weeklyStatus.any { status ->
                status != AttendanceStatus.PRESENT
            }
        }
    }
}