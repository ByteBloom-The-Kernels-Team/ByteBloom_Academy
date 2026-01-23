package domain.usecase

import domain.strategy.attendance.AttendanceStrategy

class CountMenteesWithPerfectAttendanceUseCase(
    private val attendanceStrategy: AttendanceStrategy
) {
    operator fun invoke(): Int =
        attendanceStrategy.getAttendance()
            .count()
}