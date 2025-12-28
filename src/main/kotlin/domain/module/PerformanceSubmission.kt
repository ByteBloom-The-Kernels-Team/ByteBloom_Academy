package domain.module

data class PerformanceSubmission(
    val id: String,
    val type: SubmissionType,
    val score: String
)