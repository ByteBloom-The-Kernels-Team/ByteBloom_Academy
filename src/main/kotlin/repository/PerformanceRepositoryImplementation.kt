package repository

import datasource.EcosystemDataSource
import domain.PerformanceSubmission
import domain.SubmissionType


class PerformanceRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : PerformanceRepository {
    override fun getAll(): List<PerformanceSubmission> {
        return dataSource.getPerformanceRaw().map { raw ->
            PerformanceSubmission(
                id = raw.id,
                type = mapSubmissionType(raw.type),
                score = raw.score
            )
        }
    }

    override fun getByMenteeId(menteeId: String): List<PerformanceSubmission> {
        return getAll().filter { it.id == menteeId }
    }

    override fun getByType(type: SubmissionType): List<PerformanceSubmission> {
        return getAll().filter { it.type == type }
    }

    private fun mapSubmissionType(raw: String): SubmissionType {
        return SubmissionType.valueOf(raw.uppercase())
    }
}