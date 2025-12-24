import domain.Attendance
import domain.Mentee
import domain.PerformanceSubmission
import domain.Project
import domain.Team
import repository.AttendanceRepository
import repository.MenteeRepository
import repository.PerformanceRepository
import repository.ProjectRepository
import repository.TeamRepository

class EcosystemService(
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
    private val projectRepository: ProjectRepository,
    private val attendanceRepository: AttendanceRepository,
    private val performanceRepository: PerformanceRepository
) {
    fun getPerformanceBreakdownForMentee(menteeId: String): Map<String, Double> {
        val menteePerformances = performanceRepository.getAll()
            .filter { it.menteeId == menteeId }

        if (menteePerformances.isEmpty()) return emptyMap()

        val typeAverages = menteePerformances
            .groupBy { it.type }
            .mapValues { (_, performances) ->
                performances.map { it.score.toDoubleOrNull() ?: 0.0 }
                    .average()
            }

        val overallAverage = menteePerformances
            .map { it.score.toDoubleOrNull() ?: 0.0 }
            .average()

        return typeAverages + mapOf(
            "overall_average" to overallAverage,
            "total_submissions" to menteePerformances.size.toDouble()
        )
    }

    fun findMenteesWithPerfectAttendance(): List<Mentee> {
        val allMentees = menteeRepository.getAll()
        val allAttendances = attendanceRepository.getAll()

        return allMentees.filter { mentee ->
            val menteeAttendances = allAttendances.filter { it.menteeId == mentee.id }
            menteeAttendances.all { it.status == "present" }
        }
    }


    fun flagMenteesWithPoorAttendance(minAbsences: Int): List<Mentee> {
        val allMentees = menteeRepository.getAll()
        val allAttendances = attendanceRepository.getAll()

        return allMentees.filter { mentee ->
            val menteeAttendances = allAttendances.filter { it.menteeId == mentee.id }
            val absencesCount = menteeAttendances.count { it.status == "absent" }
            absencesCount >= minAbsences
        }
    }

    fun generateTeamAttendanceReport(teamId: String): Map<String, Any> {
        val allTeams = teamRepository.getAll()
        val team = allTeams.find { it.id == teamId } ?: return emptyMap()

        val teamMentees = menteeRepository.getAll()
            .filter { it.teamId == teamId }

        val allAttendances = attendanceRepository.getAll()
        val teamAttendances = allAttendances.filter { att ->
            teamMentees.any { mentee -> mentee.id == att.menteeId }
        }

        val perfectAttendanceCount = teamMentees.count { mentee ->
            teamAttendances.filter { it.menteeId == mentee.id }
                .all { it.status == "present" }
        }

        val totalSessions = teamAttendances.groupBy { it.date }.size
        val totalPresent = teamAttendances.count { it.status == "present" }
        val averageAttendanceRate = if (totalSessions > 0) {
            (totalPresent.toDouble() / (teamMentees.size * totalSessions)) * 100
        } else 0.0

        return mapOf(
            "teamName" to team.name,
            "totalMentees" to teamMentees.size,
            "totalAttendanceRecords" to teamAttendances.size,
            "perfectAttendanceCount" to perfectAttendanceCount,
            "averageAttendanceRate" to averageAttendanceRate,
            "totalAbsences" to teamAttendances.count { it.status == "absent" }
        )
    }

}