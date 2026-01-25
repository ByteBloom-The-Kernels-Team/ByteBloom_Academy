package domain.usecase

import domain.model.Attendance
import domain.model.Mentee
import domain.model.Team
import domain.model.MenteeAttendance
import domain.repository.AttendanceRepository
import domain.repository.MenteeRepository
import domain.repository.TeamRepository

class GenerateTeamAttendanceReportUseCase(
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
    private val attendanceRepository: AttendanceRepository
) {
    operator fun invoke(): Map<String, List<MenteeAttendance>>{
        val allTeams = teamRepository.getAllTeams()
        val allMentees = menteeRepository.getAllMentees()
        val allAttendance = attendanceRepository.getAllAttendances()
        val attendanceMap = allAttendance.mapToAttendanceById()
        return allTeams.associateTeamsWithAttendance(allMentees, attendanceMap)
    }

    private fun List<Attendance>.mapToAttendanceById(): Map<String, Attendance> {
        return this.associateBy { it.menteeId }
    }

    private fun List<Team>.associateTeamsWithAttendance(
        mentees: List<Mentee>,
        attendanceMap: Map<String, Attendance>
    ): Map<String, List<MenteeAttendance>> {
        return this.associate { team ->
            val teamMentees = mentees.filterByTeamId(team.id)
            team.name to teamMentees.toMenteeAttendanceList(attendanceMap)
        }
    }

    private fun List<Mentee>.filterByTeamId(teamId: String): List<Mentee> {
        return this.filter { it.team == teamId }
    }

    private fun List<Mentee>.toMenteeAttendanceList(
        attendanceMap: Map<String, Attendance>
    ): List<MenteeAttendance> {
        return this.map { mentee ->
            MenteeAttendance(
                menteeName = mentee.name,
                weekStatuses = attendanceMap[mentee.id]?.weeklyStatus ?: emptyList()
            )
        }
    }
}