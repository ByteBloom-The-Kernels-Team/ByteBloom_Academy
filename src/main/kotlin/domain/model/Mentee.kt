package domain.model

data class Mentee(
    val id: String,
    val name: String,
    val team: String?,
    val submissions: List<PerformanceSubmission>
)