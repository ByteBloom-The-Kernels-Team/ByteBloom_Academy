package domain.mapper

import domain.model.Project

class TeamProjectMapper {
    fun map(
        teamId: String,
        projects: List<Project>
    ): Project? {
        return projects.firstOrNull { it.teamId == teamId }
    }
}