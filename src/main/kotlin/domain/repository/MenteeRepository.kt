package domain.repository
import domain.module.Mentee

interface MenteeRepository {
    fun getAll(): List<Mentee>
    fun getById(id: String): Mentee?
    fun getByTeamId(teamId: String): List<Mentee>
    fun getByName(name: String): List<Mentee>
}

