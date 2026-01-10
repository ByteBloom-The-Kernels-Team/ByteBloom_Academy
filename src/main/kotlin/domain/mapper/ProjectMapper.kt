package domain.mapper

import domain.model.Project

fun List<Project>.extractAssignedTeamIds(): Set<String> {
    return this.map { it.teamId }.toSet()
}