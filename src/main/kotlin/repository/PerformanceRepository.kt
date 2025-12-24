package repository

import domain.PerformanceSubmission

interface PerformanceRepository {
    fun getAll(): List<PerformanceSubmission>
    fun getById(id: String): List<PerformanceSubmission>
    fun getByType(type: String): List<PerformanceSubmission>
}
