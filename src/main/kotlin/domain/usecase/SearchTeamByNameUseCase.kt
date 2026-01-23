package domain.usecase

import domain.model.Team
import domain.repository.TeamRepository
import domain.strategy.team.TeamSearchStrategy

class SearchTeamByNameUseCase(
    private val teamRepository: TeamRepository,
    private val searchStrategy: TeamSearchStrategy
) {
    operator fun invoke(name: String): Team? {
        val allTeams = teamRepository.getAllTeams()
        return searchStrategy.search(allTeams, name)
    }
}