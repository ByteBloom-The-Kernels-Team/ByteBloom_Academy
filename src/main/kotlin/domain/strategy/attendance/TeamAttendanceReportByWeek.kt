package domain.strategy.attendance

import domain.model.Attendance
import domain.model.AttendanceStatus
import domain.model.MenteeAttendance
import domain.model.Mentee
import domain.model.Team

class TeamAttendanceReportByWeek : TeamAttendanceReportStrategy {

    override fun generateReport(
        teams: List<Team>,
        mentees: List<Mentee>,
        attendances: List<Attendance>
    ): Map<String, List<MenteeAttendance>> {

        val attendanceMap = mapAttendances(attendances)

        return teams.associate { team ->
            team.name to buildTeamReport(
                teamMentees = filterTeamMentees(team.id, mentees),
                attendanceMap = attendanceMap
            )
        }
    }

    private fun mapAttendances(attendances: List<Attendance>) =
        attendances.associateBy { it.menteeId }

    private fun filterTeamMentees(teamId: String, mentees: List<Mentee>) =
        mentees.filter { it.team == teamId }

    private fun buildTeamReport(
        teamMentees: List<Mentee>,
        attendanceMap: Map<String, Attendance>
    ) = teamMentees.map { mentee ->
        buildMenteeAttendance(mentee, attendanceMap)
    }

    private fun buildMenteeAttendance(
        mentee: Mentee,
        attendanceMap: Map<String, Attendance>
    ): MenteeAttendance {
        val attendance = attendanceMap[mentee.id]
        return MenteeAttendance(
            menteeName = mentee.name,
            weekStatuses = attendance?.weeklyStatus ?: emptyList<AttendanceStatus>()
        )
    }
}