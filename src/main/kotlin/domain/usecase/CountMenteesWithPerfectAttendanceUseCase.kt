package domain.usecase

import domain.model.Attendance
import domain.model.AttendanceStatus
import domain.repository.AttendanceRepository

class CountMenteesWithPerfectAttendanceUseCase(
    private val attendanceRepository: AttendanceRepository
) {
    operator fun invoke(): Int =
        attendanceRepository.getAllAttendances()
            .count { attendance -> hasPerfectWeeklyAttendance(attendance) }

    private fun hasPerfectWeeklyAttendance(attendance: Attendance): Boolean =
        attendance.weeklyStatus.all { isPerfectAttendance(it) }

    private fun isPerfectAttendance(status: AttendanceStatus): Boolean =
        status == AttendanceStatus.PRESENT
}