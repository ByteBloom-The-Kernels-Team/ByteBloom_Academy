package domain.repository
import domain.module.Team

interface TeamRepository {
    fun getAll(): List<Team>
    fun getById(id: String): Team?
    fun getByMentor(mentorName: String): List<Team>
}
