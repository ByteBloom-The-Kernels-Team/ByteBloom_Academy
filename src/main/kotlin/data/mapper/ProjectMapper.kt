package data.mapper

import data.model.ProjectRaw
import domain.model.Project

fun ProjectRaw.toDomainModel(): Project {
    return Project(
        id = id,
        title = title,
        teamId = teamId
    )
}