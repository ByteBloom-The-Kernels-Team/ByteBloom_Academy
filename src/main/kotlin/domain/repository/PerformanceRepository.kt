package domain.repository

import domain.models.PerformanceSubmission
import domain.models.SubmissionType

interface PerformanceRepository {
    fun getAll(): List<PerformanceSubmission>
    fun getByMenteeId(menteeId: String): List<PerformanceSubmission>
    fun getByType(type: SubmissionType): List<PerformanceSubmission>
}
