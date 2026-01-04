package data.mapper

import data.model.MenteeRaw
import domain.model.Mentee

fun MenteeRaw.toDomainModel(): Mentee {
    return Mentee(
        id = id,
        name = name,
        team = teamId,
        submissions = emptyList()
    )
}