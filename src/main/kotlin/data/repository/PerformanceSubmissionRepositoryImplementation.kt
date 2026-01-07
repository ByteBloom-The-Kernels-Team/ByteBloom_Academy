package data.repository

import data.datasource.EcosystemDataSource
import domain.model.PerformanceSubmission
import domain.repository.PerformanceSubmissionRepository
import data.mapper.toDomainModel

class PerformanceSubmissionRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : PerformanceSubmissionRepository {
    override fun getAllPerformanceSubmissions(): List<PerformanceSubmission> {
        return dataSource.getPerformance()
            .map {it.toDomainModel()}
    }
}