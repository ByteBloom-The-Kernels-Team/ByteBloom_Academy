package domain.strategy.team

import domain.filter.filterWithoutProjects
import domain.mapper.extractAssignedTeamIds
import domain.model.Team
import domain.repository.ProjectRepository
import domain.repository.TeamRepository

class TeamsWithoutProject(
    private val teamRepository: TeamRepository,
    private val projectRepository: ProjectRepository
) : TeamSelectionStrategy {

    override fun selectTeams(): List<Team> {
        val allTeams = teamRepository.getAllTeams()
        val allProjects = projectRepository.getAllProjects()

        val assignedTeamIds = allProjects.extractAssignedTeamIds()
        return allTeams.filterWithoutProjects(assignedTeamIds)
    }
}