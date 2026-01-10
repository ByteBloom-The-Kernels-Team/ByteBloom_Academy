package domain.strategy.attendance

import domain.filter.filterByIds
import domain.filter.withPerfectAttendance
import domain.mapper.mapToMenteeIds
import domain.model.Mentee
import domain.repository.AttendanceRepository
import domain.repository.MenteeRepository

class PerfectAttendanceByWeek(
    private val attendanceRepository: AttendanceRepository,
    private val menteeRepository: MenteeRepository
) : AttendanceStrategy {

    override fun getAttendance(): List<Mentee> {
        val menteeIDs = attendanceRepository.getAllAttendances()
            .withPerfectAttendance()
            .mapToMenteeIds()

        return menteeRepository.getAllMentees()
            .filterByIds(menteeIDs.toList())
    }
}