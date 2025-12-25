package Strategy

import Strategy.AttendanceStrategy
import domain.Attendance

class PoorAttendanceByWeek: AttendanceStrategy {
    override fun getAttendance(attendances: List<Attendance>): List<String> {
        return attendances
            .filter { it.week1Status != "Present" || it.week2Status != "Present" || it.week3Status != "Present" }
            .map { it.menteeId }
    }
}