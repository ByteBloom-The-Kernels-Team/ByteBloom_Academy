package domain.usecase

import domain.model.Attendance
import domain.model.AttendanceStatus
import domain.repository.AttendanceRepository

class GetMenteesWithLowAttendanceUseCase(
    private val attendanceRepository: AttendanceRepository
) {
    operator fun invoke(): List<String> {
        val attendanceList = attendanceRepository.getAllAttendances()
        return filterLowAttendance(attendanceList)
    }

    private fun filterLowAttendance(attendanceList: List<Attendance>): List<String> =
        attendanceList
            .filter { isLowAttendance(it.weeklyStatus) }
            .map { it.menteeId }

    private fun isLowAttendance(weeks: List<AttendanceStatus>): Boolean {
        val presentCount = weeks.count { it == AttendanceStatus.PRESENT }
        val percentage = presentCount.toDouble() / weeks.size
        return percentage < 0.5
    }
}