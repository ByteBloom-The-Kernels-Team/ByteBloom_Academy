package domain
data class Mentee(
    val id: String,
    val name: String,
    val team: Team?,
    val submissions: List<PerformanceSubmission>
)
