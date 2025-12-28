package domain.repository

import domain.module.PerformanceSubmission
import domain.module.SubmissionType

interface PerformanceRepository {
    fun getAll(): List<PerformanceSubmission>
    fun getByMenteeId(menteeId: String): List<PerformanceSubmission>
    fun getByType(type: SubmissionType): List<PerformanceSubmission>
}
