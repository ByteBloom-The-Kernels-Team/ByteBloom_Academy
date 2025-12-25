package repository
import domain.Project

interface ProjectRepository {
    fun getAll(): List<Project>
}
