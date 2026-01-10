package domain.filter

import domain.model.Project

fun List<Project>.filterByTeamId(teamId: String): List<Project> {
    return this.filter { it.teamId == teamId }
}