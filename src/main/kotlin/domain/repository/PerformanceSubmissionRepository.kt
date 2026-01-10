package domain.repository

import domain.model.PerformanceSubmission

interface PerformanceSubmissionRepository {
    fun getAllPerformanceSubmissions(): List<PerformanceSubmission>
}