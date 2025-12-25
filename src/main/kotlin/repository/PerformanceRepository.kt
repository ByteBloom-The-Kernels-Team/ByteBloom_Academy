package repository
import domain.PerformanceSubmission

interface PerformanceRepository {
    fun getAll(): List<PerformanceSubmission>
    fun getByMenteeId(id: String): List<PerformanceSubmission>
    fun getByType(type: String): List<PerformanceSubmission>
}
