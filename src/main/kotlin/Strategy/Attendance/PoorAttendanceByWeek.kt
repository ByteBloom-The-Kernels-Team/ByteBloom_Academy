package Strategy.Attendance

import domain.Attendance
import domain.AttendanceStatus

class PoorAttendanceByWeek: AttendanceStrategy {
    override fun getAttendance(attendances: List<Attendance>): List<String> {
        return attendances
            .filter { it.week1Status != AttendanceStatus.PRESENT ||
                    it.week2Status != AttendanceStatus.PRESENT ||
                    it.week3Status != AttendanceStatus.PRESENT}
            .map { it.menteeId }
    }
}