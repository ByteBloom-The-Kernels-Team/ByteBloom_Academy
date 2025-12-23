package repository
import domain.PerformanceSubmission

interface PerformanceRepository {
    fun getAll(): List<PerformanceSubmission>
}
