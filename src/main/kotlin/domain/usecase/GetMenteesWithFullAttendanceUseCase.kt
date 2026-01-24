package domain.usecase

import domain.model.Attendance
import domain.model.AttendanceStatus
import domain.repository.AttendanceRepository

class GetMenteesWithFullAttendanceUseCase(
    private val attendanceRepository: AttendanceRepository
) {
    operator fun invoke(): List<String> {
        val attendanceList = attendanceRepository.getAllAttendances()
        return filterFullAttendance(attendanceList)
    }

    private fun filterFullAttendance(attendanceList: List<Attendance>): List<String> =
        attendanceList
            .filter { hasFullAttendance(it.weeklyStatus) }
            .map { it.menteeId }

    private fun hasFullAttendance(weeks: List<AttendanceStatus>): Boolean =
        weeks.all { it == AttendanceStatus.PRESENT }
}