package domain.strategy.attendance

import domain.filter.filterByIds
import domain.filter.withPoorAttendance
import domain.mapper.mapToMenteeIds
import domain.model.Mentee
import domain.repository.AttendanceRepository
import domain.repository.MenteeRepository

class PoorAttendanceByWeek(
    private val attendanceRepository: AttendanceRepository,
    private val menteeRepository: MenteeRepository
) : AttendanceStrategy {

    override fun getAttendance(): List<Mentee> {
        val menteeIds = attendanceRepository.getAllAttendances()
            .withPoorAttendance()
            .mapToMenteeIds()

        return menteeRepository.getAllMentees()
            .filterByIds(menteeIds.toList())
    }
}