package domain.usecase

import domain.model.Attendance
import domain.repository.AttendanceRepository
import domain.model.AttendanceStatus

class CountMenteesWithPerfectAttendanceUseCase(
    private val attendanceRepository: AttendanceRepository
) {

    operator fun invoke(): Int =
        attendanceRepository.getAllAttendances()
            .count { attendance -> hasPerfectWeeklyAttendance(attendance) }

    private fun hasPerfectWeeklyAttendance(attendance: Attendance): Boolean =
        attendance.weeklyStatus.all { isPerfectAttendance(it) }

    private fun isPerfectAttendance(status: AttendanceStatus): Boolean = status == AttendanceStatus.PRESENT
}
