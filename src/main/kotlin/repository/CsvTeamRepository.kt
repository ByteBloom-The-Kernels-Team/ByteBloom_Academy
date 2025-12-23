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
}
