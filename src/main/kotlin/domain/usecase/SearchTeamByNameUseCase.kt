package domain.usecase

import domain.model.Team
import domain.repository.TeamRepository

class SearchTeamByNameUseCase(
    private val teamRepository: TeamRepository
) {
    operator fun invoke(teamName: String): Team? {
        return teamRepository.getAllTeams().findByName(teamName)
    }

    private fun List<Team>.findByName(name: String): Team? {
        return this.find { it.name.equals(name, ignoreCase = true) }
    }
}