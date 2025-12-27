package repository

import domain.PerformanceSubmission
import domain.SubmissionType

interface PerformanceRepository {
    fun getAll(): List<PerformanceSubmission>
    fun getByMenteeId(menteeId: String): List<PerformanceSubmission>
    fun getByType(type: SubmissionType): List<PerformanceSubmission>
}
