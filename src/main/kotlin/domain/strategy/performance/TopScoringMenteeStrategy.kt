package domain.strategy.performance

import domain.model.Mentee
import domain.model.PerformanceSubmission

interface TopScoringMenteeStrategy {
    fun findTopMentee(): Mentee?
}