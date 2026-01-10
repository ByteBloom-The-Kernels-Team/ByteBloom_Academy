package data.mapper

import domain.model.SubmissionType

fun String.toSubmissionType(): SubmissionType {
    return SubmissionType
        .valueOf(uppercase())
}