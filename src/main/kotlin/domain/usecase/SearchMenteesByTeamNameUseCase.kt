package domain.usecase

import domain.model.Mentee
import domain.repository.MenteeRepository

class SearchMenteesByTeamIdUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(teamId: String): List<Mentee> {
        val mentees = menteeRepository.getAllMentees()
        return findMenteesByTeamId(mentees, teamId)
    }

    private fun findMenteesByTeamId(
        mentees: List<Mentee>,
        teamId: String
    ): List<Mentee> =
        mentees
            .asSequence()
            .filter { mentee ->
                mentee.teamId?.equals(teamId, ignoreCase = true) == true
            }
            .toList()
}