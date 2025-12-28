package domain.repository
import domain.module.Project

interface ProjectRepository {
    fun getAll(): List<Project>
    fun getById(projectId: String): Project?
    fun getByTeamId(teamId: String): Project?
}
