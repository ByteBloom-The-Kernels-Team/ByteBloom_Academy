package data.mapper

import data.model.PerformanceRaw
import domain.model.PerformanceSubmission

fun PerformanceRaw.toDomainModel(): PerformanceSubmission {
    return PerformanceSubmission(
        id = id,
        menteeId = menteeId ,
        type = type.toSubmissionType(),
        score = score
    )
}