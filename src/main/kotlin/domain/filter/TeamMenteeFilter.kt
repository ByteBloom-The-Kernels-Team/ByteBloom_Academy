package domain.filter

import domain.model.Mentee
import domain.model.Team

fun List<Mentee>.filterByTeam(teamId: String): List<Mentee> =
    this.filter { it.team == teamId }

fun List<Team>.filterById(id: String): Team? =
    this.firstOrNull { it.id == id }