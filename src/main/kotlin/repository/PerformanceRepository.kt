package repository

import domain.PerformanceSubmission

interface PerformanceRepository {
    fun getAll(): List<PerformanceSubmission>
    fun getByMenteeId(menteeId: String): List<PerformanceSubmission>
    fun getByType(type: String): List<PerformanceSubmission>
}
