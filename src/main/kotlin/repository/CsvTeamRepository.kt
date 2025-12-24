package repository

import domain.Team
import parseTeamData

class CsvTeamRepository : TeamRepository {

    override fun getAll(): List<Team> {
        return parseTeamData().map { raw ->
            Team(
                id = raw.id,
                name = raw.name,
                mentor = raw.mentor,
                mentees = mutableListOf()
            )
        }
    }
    override fun getById(id: String): Team? {
        return getAll().find { it.id == id }
    }
    override fun getByMentor(mentorName: String): List<Team> {
        return getAll().filter { it.mentor.contains(mentorName, ignoreCase = true) }
    }
}
