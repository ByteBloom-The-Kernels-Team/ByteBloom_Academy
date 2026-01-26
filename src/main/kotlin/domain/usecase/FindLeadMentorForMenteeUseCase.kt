package domain.usecase

import domain.repository.MenteeRepository
import domain.repository.TeamRepository

class FindLeadMentorForMenteeUseCase(
    private val menteeRepository: MenteeRepository,
    private val teamRepository: TeamRepository
) {
    operator fun invoke(menteeId: String): String? {
        val mentee = menteeRepository.getAllMentees()
            .firstOrNull { it.id == menteeId } ?: return null

        val team = teamRepository.getAllTeams()
            .firstOrNull { it.id == mentee.teamId } ?: return null

        return team.mentor
    }
}