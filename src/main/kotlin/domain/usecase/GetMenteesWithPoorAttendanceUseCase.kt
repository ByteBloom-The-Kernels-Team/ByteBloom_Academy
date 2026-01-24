package domain.usecase

import domain.model.Attendance
import domain.model.AttendanceStatus
import domain.repository.AttendanceRepository

class GetMenteesWithPoorAttendanceUseCase(
    private val attendanceRepository: AttendanceRepository
) {
    operator fun invoke(): List<String> {
        val attendanceList = attendanceRepository.getAllAttendances()
        return filterPoorAttendance(attendanceList)
    }

    private fun filterPoorAttendance(attendanceList: List<Attendance>): List<String> =
        attendanceList
            .filter { isPoorAttendance(it.weeklyStatus) }
            .map { it.menteeId }

    private fun isPoorAttendance(weeks: List<AttendanceStatus>): Boolean {
        val presentCount = weeks.count { it == AttendanceStatus.PRESENT }
        val percentage = presentCount.toDouble() / weeks.size
        return percentage < 0.5
    }
}