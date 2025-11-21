package models
/**
 * Data class representing raw performance data from CSV
 * @property menteeId Identifier of the mentee
 * @property submissionId Unique identifier for the submission
 * @property submissionType Type of submission
 * @property score Score as String to handle potential dirty data
 */
data class PerformanceRaw(
    val menteeId: String,
    val submissionId: String,
    val submissionType: String,
    val score: String // Kept as String to handle dirty data as per requirements
)

