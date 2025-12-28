package domain.models

data class PerformanceSubmission(
    val id: String,
    val type: SubmissionType,
    val score: String
)