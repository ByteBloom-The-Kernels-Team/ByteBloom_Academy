package domain.strategy

import domain.module.Project
import domain.module.Team

class TeamsWithoutProject: TeamSelectionStrategy {
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