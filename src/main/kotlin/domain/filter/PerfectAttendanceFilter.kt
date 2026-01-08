package domain.filter

import domain.model.Attendance
import domain.model.AttendanceStatus


class PerfectAttendanceFilter {
    fun filter(
        attendances: List<Attendance>
    ): List<Attendance> {
        return attendances.filter {
            it.weeklyStatus.all { status ->
                status == AttendanceStatus.PRESENT
            }
        }
    }
}