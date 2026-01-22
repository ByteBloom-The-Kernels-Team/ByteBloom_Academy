package domain.usecase

import domain.repository.TeamRepository

class GetAllMentorsUseCase(
    private val teamRepository: TeamRepository
) {
    fun execute(): List<String> =
        teamRepository.getAllTeams().map { it.mentor }
}