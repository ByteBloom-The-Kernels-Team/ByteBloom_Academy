package Service

import Strategy.Performance.AnalyzePerformanceByType
import Strategy.Team.MentorPerTeam
import Strategy.Project.ProjectByTeamId
import Strategy.Team.TeamSelectionStrategy
import Strategy.Performance.AverageTeamPerformance
import Strategy.Attendance.PerfectAttendanceByWeek
import Strategy.Attendance.PoorAttendanceByWeek
import Strategy.Attendance.TeamAttendanceReportByWeek
import domain.Mentee
import domain.Project
import domain.Team
import domain.SubmissionType
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
    fun findTeamsWithoutProjects(
        teamSelectionStrategy: TeamSelectionStrategy
    ): List<Team> {

        val allTeams = teamRepository.getAll()
        val allProjects = projectRepository.getAll()

        return teamSelectionStrategy.selectTeams(allTeams, allProjects)
    }

    fun findProjectAssignedToTeam(teamId: String): Project? {
        val projects = projectRepository.getAll()
        val ProjectByTeamId = ProjectByTeamId()

        return ProjectByTeamId.findProjectForTeam(teamId, projects)
    }

    fun findLeadMentorForMentee(menteeId: String): String? {

        val mentees = menteeRepository.getAll()
        val teams = teamRepository.getAll()

        val mentorPerTeam = MentorPerTeam()

        return mentorPerTeam.findMentorForMentee(menteeId, mentees, teams)
    }

    fun getTeamPerformanceAverage(teamId: String): Double {

        val mentees = menteeRepository.getAll()
        val performances = performanceRepository.getAll()

        val averageTeamPerformance = AverageTeamPerformance()

        return averageTeamPerformance.calculateAverage(teamId, mentees, performances)
    }

    fun getPerformanceBreakdownForMentee(menteeId: String): Map<SubmissionType, List<Double>> {

        val performances = performanceRepository.getAll()
        val analyzePerformanceByType = AnalyzePerformanceByType()

        return analyzePerformanceByType.menteeAnalyze(menteeId, performances)
    }

    fun getMenteesWithPerfectAttendance(): List<Mentee> {
        val attendances = attendanceRepository.getAll()
        val perfectAttendanceByWeek = PerfectAttendanceByWeek()
        val prefectIDs = perfectAttendanceByWeek.getAttendance(attendances)

        val mentees = menteeRepository.getAll()
        return mentees.filter { it.id in prefectIDs }
    }

    fun getMenteesWithPoorAttendance(): List<Mentee> {
        val attendances = attendanceRepository.getAll()
        val poorAttendanceByWeek = PoorAttendanceByWeek()
        val poorIds = poorAttendanceByWeek.getAttendance(attendances)

        val mentees = menteeRepository.getAll()
        return mentees.filter { it.id in poorIds }
    }

    fun generateTeamAttendanceReport(): Map<String, List<MenteeAttendance>> {
        val teams = teamRepository.getAll()
        val mentees = menteeRepository.getAll()
        val attendances = attendanceRepository.getAll()

        val teamAttendanceReportByWeek = TeamAttendanceReportByWeek()
        return teamAttendanceReportByWeek.generateReport(teams, mentees, attendances)
    }

}