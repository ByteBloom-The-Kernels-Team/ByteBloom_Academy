
import models.TeamRaw
import models.MenteeRaw
import models.PerformanceRaw
import domain.Team
import domain.Mentee
import domain.PerformanceSubmission

class DomainBuilder(
    private val rawTeams: List<TeamRaw>,
    private val rawMentees: List<MenteeRaw>,
    private val rawSubmissions: List<PerformanceRaw>
) {
    private fun buildTeams(rawTeams: List<TeamRaw>): MutableMap<String, Team> {
        val teamsById = mutableMapOf<String, Team>()
        rawTeams.forEach { teamRaw ->
            val team = Team(
                id = teamRaw.id,
                name = teamRaw.name,
                mentor = teamRaw.mentorLead,
                mentees = mutableListOf()
            )
            teamsById[teamRaw.id] = team
        }
        return teamsById 
  }
}
