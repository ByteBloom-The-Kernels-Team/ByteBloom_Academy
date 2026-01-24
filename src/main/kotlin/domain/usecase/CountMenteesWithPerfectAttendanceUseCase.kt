package domain.usecase

import domain.repository.AttendanceRepository
import domain.model.AttendanceStatus

class CountMenteesWithPerfectAttendanceUseCase(
    private val attendanceRepository: AttendanceRepository
) {

    operator fun invoke(): Int =
        attendanceRepository.getAllAttendances()
            .count { attendance ->
                attendance.weeklyStatus.all { it == AttendanceStatus.PRESENT }
            }
}
