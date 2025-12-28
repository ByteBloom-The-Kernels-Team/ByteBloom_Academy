package Strategy.Attendance

import Service.MenteeAttendance
import Strategy.Attendance.TeamAttendanceReportStrategy
import domain.Attendance
import domain.Mentee
import domain.Team

class TeamAttendanceReportByWeek: TeamAttendanceReportStrategy {

    override fun generateReport(
        teams: List<Team>,
        mentees: List<Mentee>,
        attendances: List<Attendance>
    ): Map<String, List<MenteeAttendance>> {

        val attendanceMap = attendances.associateBy { it.menteeId }

        return teams.associate { team ->
            val teamMentees = mentees.filter { it.team == team.id }
            val menteeAttendanceList = teamMentees.map { mentee ->
                buildMenteeAttendance(mentee, attendanceMap)
            }
            team.name to menteeAttendanceList
        }
    }

    private fun buildMenteeAttendance(
        mentee: Mentee,
        attendanceMap: Map<String, Attendance>
    ): MenteeAttendance {
        val att = attendanceMap[mentee.id]
        return MenteeAttendance(
            menteeName = mentee.name,
            weekStatuses = listOf(
                att?.week1Status?.name ?: "N/A",
                att?.week2Status?.name ?: "N/A",
                att?.week3Status?.name ?: "N/A"
            )
        )
    }
}