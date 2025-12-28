package domain.strategy.attendance

import domain.models.Attendance

interface AttendanceStrategy {
    fun getAttendance(attendances: List<Attendance>): List<String>
}