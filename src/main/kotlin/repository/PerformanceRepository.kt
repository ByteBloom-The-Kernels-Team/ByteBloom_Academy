package repository

import domain.PerformanceSubmission
import domain.SubmissionType

interface PerformanceRepository {
    fun getAll(): List<PerformanceSubmission>
    fun getByMenteeId(id: String): List<PerformanceSubmission>
    fun getByType(type: SubmissionType): List<PerformanceSubmission>
    fun mapSubmissionType(raw: String): SubmissionType
}
