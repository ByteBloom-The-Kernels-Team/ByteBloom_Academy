package domain.repository
import domain.models.Project

interface ProjectRepository {
    fun getAll(): List<Project>
    fun getById(projectId: String): Project?
    fun getByTeamId(teamId: String): Project?
}
