package domain.filter

import domain.model.Mentee
import domain.model.SubmissionType

fun List<Mentee>.filterByIds(ids: List<String>): List<Mentee> =
    this.filter { it.id in ids }

fun List<Mentee>.filterById(id: String): Mentee? =
    this.filterByIds(listOf(id)).firstOrNull()

fun List<Mentee>.filterByName(query: String): List<Mentee> =
    this.filter { mentee ->
        mentee.name.contains(query, ignoreCase = true)
    }

fun List<Mentee>.filterTopByOverallScore(limit: Int): List<Mentee> =
    this.sortedByDescending { mentee ->
        mentee.submissions.sumOf { it.score.toIntOrNull() ?: 0 }
    }.take(limit)

fun List<Mentee>.filterBySubmissionType(type: SubmissionType): List<Mentee> =
    this.filter { mentee ->
        mentee.submissions.any { it.type == type }
    }