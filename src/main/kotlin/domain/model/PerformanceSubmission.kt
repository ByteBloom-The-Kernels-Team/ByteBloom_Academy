package domain.model

data class PerformanceSubmission(
    val id: String,
    val menteeIds: List<String>,
    val type: SubmissionType,
    val score: String
)