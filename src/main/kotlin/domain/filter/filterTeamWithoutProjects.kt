package domain.filter

import domain.model.Team

fun List<Team>.filterWithoutProjects(assignedTeamIds: Set<String>): List<Team> =
    this.filter { it.id !in assignedTeamIds }