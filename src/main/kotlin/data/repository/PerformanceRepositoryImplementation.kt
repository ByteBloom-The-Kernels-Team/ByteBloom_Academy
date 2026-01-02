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
        return dataSource.getPerformance().map {it.toDomainModel()}
    }

    override fun getPerformanceSubmissionByMenteeId(menteeId: String): List<PerformanceSubmission> {
        return getAllPerformanceSubmissions().filter { it.id == menteeId }
    }

    override fun getPerformanceSubmissionByType(type: SubmissionType): List<PerformanceSubmission> {
        return getAllPerformanceSubmissions().filter { it.type == type }
    }
    override fun getPerformanceSubmissionById(id: String): PerformanceSubmission? {
        return getAllPerformanceSubmissions().find { it.id == id }
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