import data.dto.TeamRaw
import data.dto.MenteeRaw
import data.dto.PerformanceRaw
import domain.module.Team
import domain.module.Mentee
import domain.module.PerformanceSubmission
import domain.module.SubmissionType

class DomainBuilder(
    private val rawTeams: List<TeamRaw>,
    private val rawMentees: List<MenteeRaw>,
    private val rawSubmissions: List<PerformanceRaw>
) {

    private fun buildTeam(teamRaw: TeamRaw): Team {
        return Team(
            id = teamRaw.id,
            name = teamRaw.name,
            mentor = teamRaw.mentor,
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

    private fun buildMentee(
        menteeRaw: MenteeRaw,
        team: Team,
        submissions: List<PerformanceSubmission>
    ): Mentee {
        return Mentee(
            menteeRaw.id,
            menteeRaw.name,
            team.id,
            submissions
        )
    }

    private fun attachMenteesToTeams(
        teamsById: MutableMap<String, Team>,
        submissionsByMentee: Map<String, List<PerformanceSubmission>>
    ) {
        rawMentees.forEach  { menteeRaw ->
            val team = teamsById[menteeRaw.teamId]
            if (team != null) {
                val submissions = submissionsByMentee[menteeRaw.id] ?: emptyList()
                val mentee = buildMentee(menteeRaw, team, submissions)
                team.mentees.add(mentee)
            }
        }
    }

    private fun buildSubmission(submissionRaw: PerformanceRaw): PerformanceSubmission {
        return PerformanceSubmission(
            id = submissionRaw.id,
            type = SubmissionType.valueOf(submissionRaw.type),
            score = submissionRaw.score
        )
    }

    private fun buildSubmissionsMap(): Map<String, List<PerformanceSubmission>> {
        val submissionsByMentee = mutableMapOf<String, MutableList<PerformanceSubmission>>()
        rawSubmissions.forEach { submissionRaw ->
            val submission = buildSubmission(submissionRaw)
            val submissionsList = submissionsByMentee.getOrPut(submissionRaw.menteeId) { mutableListOf() }
            submissionsList.add(submission)
        }
        return submissionsByMentee
    }

    fun buildDomain(): List<Team> {
        val teamsMappedById = buildTeamsMap()
        val submissionsMappedByMenteeId = buildSubmissionsMap()
        attachMenteesToTeams(teamsMappedById, submissionsMappedByMenteeId)
        return teamsMappedById.values.toList()
    }
}
