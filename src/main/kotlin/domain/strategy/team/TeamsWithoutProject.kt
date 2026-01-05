package domain.strategy.team

import domain.model.Project
import domain.model.Team

class TeamsWithoutProject : TeamSelectionStrategy {

    override fun selectTeams(
        teams: List<Team>,
        projects: List<Project>
    ): List<Team> {
        val assignedTeamIds = extractAssignedTeamIds(projects)
        return filterTeamsWithoutProjects(teams, assignedTeamIds)
    }

    private fun extractAssignedTeamIds(projects: List<Project>): Set<String> {
        return projects.map { it.teamId }.toSet()
    }

    private fun filterTeamsWithoutProjects(
        teams: List<Team>,
        assignedTeamIds: Set<String>
    ): List<Team> {
        return teams.filter { it.id !in assignedTeamIds }
    }
}