
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
      private fun buildTeam(teamRaw: TeamRaw): Team {
        return Team(
            id = teamRaw.id,
            name = teamRaw.name,
            mentor = teamRaw.mentorLead,
            mentees = mutableListOf()
        )
    }
    private fun buildTeamsMap(): MutableMap<String, Team> {
        val teamsById = mutableMapOf<String, Team>()
        rawTeams.forEach { teamRaw ->
            teamsById[teamRaw.id] = buildTeam(teamRaw)
        }
        return teamsById
    }
    }

    private fun buildMentees(
        rawMentees: List<MenteeRaw>,
        teamsById: MutableMap<String, Team>,
        submissionsByMentee: MutableMap<String, List<PerformanceSubmission>>
    ) {
        rawMentees.forEach { menteeRaw ->
            val team = teamsById[menteeRaw.teamId]
            if (team != null) {
                val submissions = submissionsByMentee[menteeRaw.id] ?: emptyList()

                val mentee = Mentee(
                    id = menteeRaw.id,
                    name = menteeRaw.name,
                    team = team,
                    submissions = submissions
                )

                team.mentees.add(mentee)
            }
        }
    }

    private fun buildPerformanceSubmissions(rawSubmissions: List<PerformanceRaw>): MutableMap<String, List<PerformanceSubmission>>{
        val submissionByMentee = mutableMapOf<String, List<PerformanceSubmission>>()

        rawSubmissions.forEach { submissionRaw ->
            val submission = PerformanceSubmission(
                submissionId = submissionRaw.submissionId,
                type = submissionRaw.submissionType,
                score = submissionRaw.score
            )
            val currentList = submissionByMentee[submissionRaw.menteeId] ?: emptyList()
            submissionByMentee[submissionRaw.menteeId] = currentList + submission
        }
        return submissionByMentee
    }
}
