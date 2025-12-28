package data.repository

import domain.module.PerformanceSubmission
import domain.module.SubmissionType
import parsePerformanceData
import domain.repository.PerformanceRepository

class CsvPerformanceRepository : PerformanceRepository {

    override fun getAll(): List<PerformanceSubmission> {
        return parsePerformanceData().map { raw ->
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