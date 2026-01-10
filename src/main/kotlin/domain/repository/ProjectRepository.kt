package domain.repository

import domain.model.Project

interface ProjectRepository {
    fun getAllProjects(): List<Project>
    fun getProjectById(projectId: String): Project?
    fun getProjectByTeamId(teamId: String): Project?
}