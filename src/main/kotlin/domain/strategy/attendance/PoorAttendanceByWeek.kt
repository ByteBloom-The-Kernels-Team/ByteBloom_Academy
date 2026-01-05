package domain.strategy.attendance

import domain.model.Attendance
import domain.model.AttendanceStatus

class PoorAttendanceByWeek : AttendanceStrategy {

    override fun getAttendance(attendances: List<Attendance>): List<String> {
        return attendances
            .filter { hasPoorAttendance(it) }
            .map { it.menteeId }
    }

    private fun hasPoorAttendance(attendance: Attendance): Boolean {
        return attendance.weeklyStatus.any { it != AttendanceStatus.PRESENT }
    }
}