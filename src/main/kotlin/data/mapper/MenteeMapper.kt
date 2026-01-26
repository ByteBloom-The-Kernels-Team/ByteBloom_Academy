package data.mapper

import data.model.MenteeRaw
import domain.model.Mentee

fun MenteeRaw.toDomainModel(): Mentee {
    return Mentee(
        id = id,
        name = name,
        teamId = this@toDomainModel.teamId,
        submissions = emptyList()
    )
}