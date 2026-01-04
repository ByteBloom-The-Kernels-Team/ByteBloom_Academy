package domain.repository

import domain.model.Mentee

interface MenteeRepository {
    fun getAllMentees(): List<Mentee>
    fun getMenteeById(id: String): Mentee?
    fun getMenteesByTeamId(teamId: String): List<Mentee>
    fun getMenteeByName(name: String): List<Mentee>
}

