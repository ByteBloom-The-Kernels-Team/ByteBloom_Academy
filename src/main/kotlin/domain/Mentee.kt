package domain
data class Mentee(
    val id: String,
    val name: String,
    var teamId: String?,
    val submissions: List<PerformanceSubmission>
)
