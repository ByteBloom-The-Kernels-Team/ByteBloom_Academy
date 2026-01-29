package domain.usecase

import domain.model.AttendanceStatus
import domain.model.Attendance
import domain.repository.AttendanceRepository

class CountMenteesWithPoorAttendanceUseCase(
    private val attendanceRepository: AttendanceRepository
){
    operator fun invoke(): Int {
        val allAttendance = attendanceRepository.getAllAttendances()
        return allAttendance.countPoorStatus()
    }

    private fun List<Attendance>.countPoorStatus(): Int =
        count { attendance ->
            attendance.weeklyStatus.any { it != AttendanceStatus.PRESENT }
        }
}