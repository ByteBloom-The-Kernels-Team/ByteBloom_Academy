package domain.filter

import domain.model.Mentee

fun List<Mentee>.filterByIds(ids: List<String>): List<Mentee> =
    this.filter { it.id in ids }

fun List<Mentee>.filterById(id: String): Mentee? =
    this.filterByIds(listOf(id)).firstOrNull()

fun List<Mentee>.filterByName(query: String): List<Mentee> =
    this.filter { mentee ->
        mentee.name.contains(query, ignoreCase = true)
    }