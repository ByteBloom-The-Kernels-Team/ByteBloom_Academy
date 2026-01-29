package domain.usecase

import domain.model.Team
import domain.repository.TeamRepository
import domain.repository.ProjectRepository

class FindTeamsWithNoProjectUseCase(
    private val teamRepository: TeamRepository,
    private val projectRepository: ProjectRepository
) {
    operator fun invoke(): List<Team> {
        val allTeams = teamRepository.getAllTeams()
        val allProjectsAssignedTeamIds = findProjectsAssignedTeamIds()

        return allTeams
            .asSequence()
            .filterNot { team ->
                team.id in allProjectsAssignedTeamIds
            }.toList()
    }

    private fun findProjectsAssignedTeamIds(): Set<String> {
        return projectRepository.getAllProjects()
            .asSequence()
            .map { it.teamId }
            .toSet()
    }
}