package Strategy

import Strategy.TopScoringMenteeStrategy
import domain.Mentee
import domain.PerformanceSubmission

class HighestAverageScoreMenteeStrategy: TopScoringMenteeStrategy {
    override fun findTopMentee(
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Mentee? {
        return mentees.maxByOrNull { mentee ->
            performances
                .filter { it.id == mentee.id }
                .mapNotNull { it.score.toDoubleOrNull() }
                .average()
        }
    }
}