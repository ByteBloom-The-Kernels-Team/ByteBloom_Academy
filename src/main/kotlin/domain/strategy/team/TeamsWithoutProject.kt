package domain.strategy.team

import domain.models.Project
import domain.models.Team

class TeamsWithoutProject : TeamSelectionStrategy {
    override fun selectTeams(
        teams: List<Team>,
        projects: List<Project>
    ): List<Team> {
        val teamIdsWithAssignedProjects =
            projects.map { it.teamId }.toSet()

        return teams.filter { team ->
            team.id !in teamIdsWithAssignedProjects
        }
    }
}