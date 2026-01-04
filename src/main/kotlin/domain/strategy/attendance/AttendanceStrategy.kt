package domain.strategy.attendance

import domain.model.Attendance

interface AttendanceStrategy {
    fun getAttendance(attendances: List<Attendance>): List<String>
}