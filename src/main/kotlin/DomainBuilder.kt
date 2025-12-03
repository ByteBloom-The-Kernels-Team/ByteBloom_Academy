
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

}