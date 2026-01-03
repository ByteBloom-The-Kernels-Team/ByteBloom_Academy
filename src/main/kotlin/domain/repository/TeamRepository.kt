package domain.repository

import domain.model.Team

interface TeamRepository {
    fun getAllTeams(): List<Team>
    fun getTeamById(id: String): Team?
    fun getTeamByMentor(mentorName: String): List<Team>
}