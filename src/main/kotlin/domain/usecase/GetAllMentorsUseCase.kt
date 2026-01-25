package domain.usecase

import domain.repository.TeamRepository

class GetAllMentorsUseCase(
    private val teamRepository: TeamRepository
) {
    operator fun invoke(): List<String> =
        teamRepository.getAllTeams()
            .map { it.mentor }
}