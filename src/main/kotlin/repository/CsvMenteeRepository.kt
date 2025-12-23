package repository

import domain.Mentee
import parseMenteeData

class CsvMenteeRepository : MenteeRepository {

    override fun getAll(): List<Mentee> {
        return parseMenteeData().map { raw ->
            Mentee(
                id = raw.id,
                name = raw.name,
                team = raw.teamId,
                submissions = emptyList()
            )
        }
    }
}

