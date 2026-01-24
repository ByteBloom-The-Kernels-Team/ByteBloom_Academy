package domain.usecase

import domain.model.Attendance
import domain.model.AttendanceStatus
import domain.repository.AttendanceRepository

class GetMenteesWithPerfectAttendanceUseCase(
    private val attendanceRepository: AttendanceRepository
) {
    operator fun invoke(): List<String> {
        val attendanceList = attendanceRepository.getAllAttendances()
        return filterPerfectAttendance(attendanceList)
    }

    private fun filterPerfectAttendance(attendanceList: List<Attendance>): List<String> =
        attendanceList
            .filter { hasPerfectAttendance(it.weeklyStatus) }
            .map { it.menteeId }

    private fun hasPerfectAttendance(weeks: List<AttendanceStatus>): Boolean =
        weeks.all { it == AttendanceStatus.PRESENT }
}