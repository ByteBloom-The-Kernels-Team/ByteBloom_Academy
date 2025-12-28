package domain.strategy.attendance

import domain.module.Attendance

interface AttendanceStrategy {
    fun getAttendance(attendances: List<Attendance>): List<String>
}