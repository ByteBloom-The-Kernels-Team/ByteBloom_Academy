package Strategy.Attendance

import domain.Attendance

interface AttendanceStrategy {
    fun getAttendance(attendances: List<Attendance>): List<String>
}