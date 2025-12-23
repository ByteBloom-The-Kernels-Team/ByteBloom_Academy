package repository

import domain.PerformanceSubmission
import parsePerformanceData

class CsvPerformanceRepository : PerformanceRepository {

    override fun getAll(): List<PerformanceSubmission> {
        return parsePerformanceData().map { raw ->
            PerformanceSubmission(
                id = raw.id,
                type = raw.type,
                score = raw.score
            )
        }
    }
}