package domain.usecase

import domain.model.AttendanceStatus
import domain.repository.TeamRepository
import domain.repository.AttendanceRepository

class GenerateTeamAttendanceReportUseCase(
    private val teamRepository: TeamRepository,
    private val attendanceRepository: AttendanceRepository
) {
    operator fun invoke(): Map<String, List<Map<String, MutableList<AttendanceStatus>>>> {
        val teams = teamRepository.getAllTeams()
        return teams.associate { team ->
            team.name to attendanceRepository.getAllAttendances()
                .asSequence()
                .filter { it.menteeId in team.menteeIds }
                .map { mapOf(it.menteeId to it.weeklyStatus) }
                .toList()
        }
    }
}