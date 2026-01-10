package domain.filter

import domain.model.Mentee

fun List<Mentee>.filterByIds(ids: List<String>): List<Mentee> =
    this.filter { it.id in ids }

fun List<Mentee>.filterById(id: String): Mentee? =
    this.firstOrNull { it.id == id }