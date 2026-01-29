package domain.usecase

import domain.repository.MenteeRepository

class FindCountMenteesInTeamUseCase(
    private val menteeRepository: MenteeRepository,
) {
    operator fun invoke(teamId: String): Int {
        val allMentees = menteeRepository.getAllMentees()
        val menteesCount = allMentees.count { it.teamId == teamId }
        return menteesCount
    }
}