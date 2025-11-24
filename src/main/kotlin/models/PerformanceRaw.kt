package models
// Raw performance data from CSV
data class PerformanceRaw(
    val menteeId: String,
    val submissionId: String,
    val type: String,
    val score: String // kept as String to handle dirty data
)

