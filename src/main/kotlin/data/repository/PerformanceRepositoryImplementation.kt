package data.repository

import data.datasource.EcosystemDataSource
import domain.model.PerformanceSubmission
import domain.model.SubmissionType
import domain.repository.PerformanceSubmissionRepository
import data.model.PerformanceRaw

class PerformanceRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : PerformanceSubmissionRepository {
    override fun getAllPerformanceSubmissions(): List<PerformanceSubmission> {
        return dataSource.getPerformance()
            .map {it.toDomainModel()}
    }

    override fun getPerformanceSubmissionByMenteeId(menteeId: String): List<PerformanceSubmission> {
        return dataSource.getPerformance()
            .filter { it.menteeId == menteeId }
            .map {it.toDomainModel()}
    }

    override fun getPerformanceSubmissionByType(type: SubmissionType): List<PerformanceSubmission> {
        return dataSource.getPerformance()
            .filter { it.type.toSubmissionType()== type}
            .map {it.toDomainModel()}
    }
    override fun getPerformanceSubmissionById(id: String): PerformanceSubmission? {
        return dataSource.getPerformance()
            .find { it.id == id }
            ?.toDomainModel()
    }
}
private fun String.toSubmissionType(): SubmissionType {
    return SubmissionType.valueOf(uppercase())
}
private fun PerformanceRaw.toDomainModel(): PerformanceSubmission {
    return PerformanceSubmission(
        id = id,
        menteeIds = listOf(menteeId),
        type = type.toSubmissionType(),
        score = score
    )
}