package Strategy

import domain.PerformanceSubmission

class AnalyzePerformanceByType: MenteePerformanceAnalyzer {
    override fun menteeAnalyze(
        menteeId: String,
        performances: List<PerformanceSubmission>
    ): Map<String, List<Double>> {
        return performances
            .filter { it.id == menteeId }
            .groupBy { it.type }
            .mapValues { entry ->
                entry.value.mapNotNull { it.score.toDoubleOrNull() }
            }
    }
}