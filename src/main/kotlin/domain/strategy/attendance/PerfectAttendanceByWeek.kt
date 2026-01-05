package domain.strategy.attendance

import domain.model.Attendance
import domain.model.AttendanceStatus

class PerfectAttendanceByWeek : AttendanceStrategy {

    override fun getAttendance(attendances: List<Attendance>): List<String> {
        return attendances
            .filter { hasPerfectAttendance(it) }
            .map { it.menteeId }
    }

    private fun hasPerfectAttendance(attendance: Attendance): Boolean {
        return attendance.weeklyStatus
            .all { it == AttendanceStatus.PRESENT }
    }
}