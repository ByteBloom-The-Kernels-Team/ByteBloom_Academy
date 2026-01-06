package domain.assmebler

import domain.filter.TeamMenteeFilter
import domain.mapper.MenteeAttendanceMapper
import domain.model.Attendance
import domain.model.Mentee
import domain.model.MenteeAttendance
import domain.model.Team
import domain.strategy.attendance.AttendanceIndex

class TeamAttendanceReportAssembler(
    private val teamMenteeFilter: TeamMenteeFilter,
    private val attendanceIndex: AttendanceIndex,
    private val menteeAttendanceMapper: MenteeAttendanceMapper
) {
    fun assemble(
        teams: List<Team>,
        mentees: List<Mentee>,
        attendances: List<Attendance>
    ): Map<String, List<MenteeAttendance>> {

        val attendanceMap = attendanceIndex.index(attendances)

        return teams.associate { team ->
            val teamMentees = teamMenteeFilter.filterByTeam(team.id, mentees)

            val report = teamMentees.map { mentee ->
                menteeAttendanceMapper.map(
                    mentee,
                    attendanceMap[mentee.id]
                )
            }

            team.name to report
        }
    }
}