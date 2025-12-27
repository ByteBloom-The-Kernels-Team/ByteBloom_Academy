package repository

import domain.PerformanceSubmission
import datasource.EcosystemDataSource

class PerformanceRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : PerformanceRepository {


    override fun getAll(): List<PerformanceSubmission> {
        return dataSource.getPerformanceRaw().map { raw ->
            PerformanceSubmission(
                id = raw.id,
                type = raw.type,
                score = raw.score
            )
        }
    }

    override fun getByMenteeId(id: String): List<PerformanceSubmission> {
        return getAll().filter { it.id == id }
    }

    override fun getByType(type: String): List<PerformanceSubmission> {
        return getAll().filter { it.type.equals(type, ignoreCase = true) }
    }
}