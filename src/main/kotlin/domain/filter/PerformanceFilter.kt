package domain.filter

import domain.model.PerformanceSubmission

fun List<PerformanceSubmission>.filterByMentee(
    menteeId: String
): List<PerformanceSubmission> =
    this.filter { it.menteeId == menteeId }

fun List<PerformanceSubmission>.filterByMentees(
    menteeIds: List<String>
): List<PerformanceSubmission> =
    this.filter { it.menteeId in menteeIds }