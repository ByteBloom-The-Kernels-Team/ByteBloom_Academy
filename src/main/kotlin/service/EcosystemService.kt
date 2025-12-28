package service

import domain.strategy.performance.AnalyzePerformanceByType
import domain.strategy.team.MentorPerTeam
import domain.strategy.project.ProjectByTeamId
import domain.strategy.team.TeamSelectionStrategy
import domain.strategy.performance.AverageTeamPerformance
import domain.strategy.attendance.PerfectAttendanceByWeek
import domain.strategy.attendance.PoorAttendanceByWeek
import domain.strategy.attendance.TeamAttendanceReportByWeek
import domain.models.Mentee
import domain.models.Project
import domain.models.Team
import domain.models.SubmissionType
import domain.repository.AttendanceRepository
import domain.repository.MenteeRepository
import domain.repository.PerformanceRepository
import domain.repository.ProjectRepository
import domain.repository.TeamRepository
import domain.strategy.attendance.MenteeAttendance

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