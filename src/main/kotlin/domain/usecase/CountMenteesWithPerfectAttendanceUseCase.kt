package domain.usecase

import domain.strategy.attendance.AttendanceStrategy

class CountMenteesWithPerfectAttendanceUseCase(
    private val attendanceStrategy: AttendanceStrategy
) {

    fun execute(): Int =
        attendanceStrategy.getAttendance()
            .count()
}
