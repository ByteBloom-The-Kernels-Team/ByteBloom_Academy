package domain.usecase

import domain.model.Mentee
import domain.repository.MenteeRepository

class SearchMenteesByTeamNameUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(teamName: String): List<Mentee> {
        val mentees = menteeRepository.getAllMentees()
        return filterByTeamName(mentees, teamName)
    }

    private fun filterByTeamName(
        mentees: List<Mentee>,
        teamName: String
    ): List<Mentee> =
        mentees.filter { mentee ->
            mentee.teamId?.equals(teamName, ignoreCase = true) == true
        }
}