package domain.strategy.attendance

import domain.model.Attendance
import domain.model.AttendanceStatus
import domain.model.Mentee
import domain.model.Team

class TeamAttendanceReportByWeek : TeamAttendanceReportStrategy {

    override fun generateReport(
        teams: List<Team>,
        mentees: List<Mentee>,
        attendances: List<Attendance>
    ): Map<String, List<MenteeAttendance>> {

        val attendanceByMenteeId = attendances.associateBy { it.menteeId }

        return teams.associate { team ->
            val teamMentees = mentees.filter { it.team == team.id }
            val menteeAttendanceList = teamMentees.map { mentee ->
                buildMenteeAttendance(mentee, attendanceByMenteeId)
            }
            team.name to menteeAttendanceList
        }
    }

    private fun buildMenteeAttendance(
        mentee: Mentee,
        attendanceByMenteeId: Map<String, Attendance>
    ): MenteeAttendance {
        val attendence = attendanceByMenteeId[mentee.id]
        return MenteeAttendance(
            menteeName = mentee.name,
            weekStatuses = listOf(
                attendence?.week1Status ?: AttendanceStatus.ABSENT,
                attendence?.week2Status ?: AttendanceStatus.ABSENT,
                attendence?.week3Status ?: AttendanceStatus.ABSENT
            )
        )
    }
}