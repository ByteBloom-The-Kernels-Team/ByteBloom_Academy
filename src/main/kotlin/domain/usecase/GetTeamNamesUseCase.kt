package domain.usecase

import domain.repository.TeamRepository

class GetTeamNamesUseCase(
    private val teamRepository: TeamRepository
) {
    operator fun invoke(): List<String> {
        return teamRepository
            .getAllTeams()
            .mapNotNull { it.name }
    }
}