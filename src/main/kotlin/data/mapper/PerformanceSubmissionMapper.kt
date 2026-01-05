package data.mapper

import data.model.PerformanceRaw
import domain.model.PerformanceSubmission
import domain.model.SubmissionType

fun String.toSubmissionType(): SubmissionType {
    return SubmissionType
        .valueOf(uppercase())
}
fun PerformanceRaw.toDomainModel(): PerformanceSubmission {
    return PerformanceSubmission(
        id = id,
        menteeId = menteeId ,
        type = type.toSubmissionType(),
        score = score
    )
}