package domain.usecase

import domain.model.Project
import domain.repository.ProjectRepository

class FindProjectByTeamIdUseCase (
    private val projectRepository: ProjectRepository
) {
    operator fun invoke(teamId: String): Project? =
         projectRepository.getAllProjects()
            .firstOrNull { it.teamId == teamId }
}