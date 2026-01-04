package data.mapper

import data.model.TeamRaw
import domain.model.Team

fun TeamRaw.toDomainModel(): Team {
    return Team(
        id = id,
        name = name,
        mentor = mentor,
        menteeIds = mutableListOf()
    )
}