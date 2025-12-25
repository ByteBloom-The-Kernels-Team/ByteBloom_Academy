package Strategy

import domain.Attendance

interface AttendanceStrategy {
    fun getAttendance(attendances: List<Attendance>): List<String>
}