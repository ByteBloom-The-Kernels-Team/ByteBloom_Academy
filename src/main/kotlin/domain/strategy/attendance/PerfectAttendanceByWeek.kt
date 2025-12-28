package domain.strategy.attendance

import domain.module.Attendance
import domain.module.AttendanceStatus

class PerfectAttendanceByWeek: AttendanceStrategy {
    override fun getAttendance(attendances: List<Attendance>): List<String> {
        return attendances
            .filter { it.week1Status == AttendanceStatus.PRESENT &&
                    it.week2Status == AttendanceStatus.PRESENT &&
                    it.week3Status == AttendanceStatus.PRESENT }
            .map { it.menteeId }
    }
}