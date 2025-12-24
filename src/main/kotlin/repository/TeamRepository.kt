package repository

import domain.Team

interface TeamRepository {
    fun getAll(): List<Team>
    fun getById(id: String): Team?
    fun getByMentor(mentorName: String): List<Team>
}
