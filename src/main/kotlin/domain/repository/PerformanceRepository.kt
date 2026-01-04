package domain.repository

import domain.model.PerformanceSubmission
import domain.model.SubmissionType

interface PerformanceSubmissionRepository {
    fun getAllPerformanceSubmissions(): List<PerformanceSubmission>
    fun getPerformanceSubmissionByMenteeId(menteeId: String): List<PerformanceSubmission>
    fun getPerformanceSubmissionByType(type: SubmissionType): List<PerformanceSubmission>
    fun getPerformanceSubmissionById(id: String): PerformanceSubmission?
}
