package repository
import domain.Team

interface TeamRepository {
    fun getAll(): List<Team>
}
