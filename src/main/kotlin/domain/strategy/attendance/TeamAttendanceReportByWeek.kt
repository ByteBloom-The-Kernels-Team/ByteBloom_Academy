package domain.strategy.attendance

import domain.filter.filterByIds
import domain.mapper.mapByMenteeId
import domain.mapper.weeklyStatusOrEmpty
import domain.model.Attendance
import domain.model.MenteeAttendance
import domain.model.Mentee
import domain.repository.AttendanceRepository
import domain.repository.MenteeRepository
import domain.repository.TeamRepository

class TeamAttendanceReportByWeek(
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
    private val attendanceRepository: AttendanceRepository
) : TeamAttendanceReportStrategy {

    override fun generateReport(): Map<String, List<MenteeAttendance>> {

        val attendanceMap = attendanceRepository.getAllAttendances()
            .mapByMenteeId()

        val allMentees = menteeRepository.getAllMentees()
        val allTeams = teamRepository.getAllTeams()

        return allTeams.associate { team ->
            val teamMentees = allMentees.filterByIds(listOf(team.id))
            team.name to buildTeamReport(teamMentees, attendanceMap)
        }
    }

    private fun buildTeamReport(
        teamMentees: List<Mentee>,
        attendanceMap: Map<String, Attendance>
    ) =
        teamMentees.map { mentee ->
        buildMenteeAttendance(mentee, attendanceMap)
    }

    private fun buildMenteeAttendance(
        mentee: Mentee,
        attendanceMap: Map<String, Attendance>
    ) =
        MenteeAttendance(
        menteeName = mentee.name,
        weekStatuses = attendanceMap[mentee.id]?.weeklyStatusOrEmpty() ?: emptyList()
    )
}