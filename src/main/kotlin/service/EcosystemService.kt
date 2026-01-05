package service

import domain.strategy.performance.AnalyzePerformanceByType
import domain.strategy.team.MentorPerTeam
import domain.strategy.project.ProjectByTeamId
import domain.strategy.team.TeamSelectionStrategy
import domain.strategy.performance.AverageTeamPerformance
import domain.strategy.attendance.PerfectAttendanceByWeek
import domain.strategy.attendance.PoorAttendanceByWeek
import domain.strategy.attendance.TeamAttendanceReportByWeek
import domain.model.Mentee
import domain.model.MenteeAttendance
import domain.model.Project
import domain.model.Team
import domain.model.SubmissionType
import domain.repository.AttendanceRepository
import domain.repository.MenteeRepository
import domain.repository.PerformanceSubmissionRepository
import domain.repository.ProjectRepository
import domain.repository.TeamRepository

class EcosystemService(
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
    private val projectRepository: ProjectRepository,
    private val attendanceRepository: AttendanceRepository,
    private val performanceRepository: PerformanceSubmissionRepository
) {
    fun findTeamsWithoutProjects(
        teamSelectionStrategy: TeamSelectionStrategy
    ): List<Team> {
        val allTeams = teamRepository.getAllTeams()
        val allProjects = projectRepository.getAllProjects()

        return teamSelectionStrategy.selectTeams(allTeams, allProjects)
    }

    fun findProjectAssignedToTeam(teamId: String): Project? {
        val projects = projectRepository.getAllProjects()
        val projectByTeamId = ProjectByTeamId()

        return projectByTeamId.findProjectForTeam(teamId, projects)
    }

    fun findLeadMentorForMentee(menteeId: String): String? {
        val mentees = menteeRepository.getAllMentees()
        val teams = teamRepository.getAllTeams()
        val mentorPerTeam = MentorPerTeam()

        return mentorPerTeam.findMentorForMentee(menteeId, mentees, teams)
    }

    fun getTeamPerformanceAverage(teamId: String): Double {
        val mentees = menteeRepository.getAllMentees()
        val performances = performanceRepository.getAllPerformanceSubmissions()
        val averageTeamPerformance = AverageTeamPerformance()

        return averageTeamPerformance.calculateAverage(teamId, mentees, performances)
    }

    fun getPerformanceBreakdownForMentee(menteeId: String): Map<SubmissionType, List<Double>> {
        val performances = performanceRepository.getAllPerformanceSubmissions()
        val analyzePerformanceByType = AnalyzePerformanceByType()

        return analyzePerformanceByType.menteeAnalyze(menteeId, performances)
    }

    fun getMenteesWithPerfectAttendance(): List<Mentee> {
        val attendances = attendanceRepository.getAllAttendances()
        val perfectAttendanceByWeek = PerfectAttendanceByWeek()
        val prefectIDs = perfectAttendanceByWeek.getAttendance(attendances)
        val mentees = menteeRepository.getAllMentees()

        return mentees.filter { it.id in prefectIDs }
    }

    fun getMenteesWithPoorAttendance(): List<Mentee> {
        val attendances = attendanceRepository.getAllAttendances()
        val poorAttendanceByWeek = PoorAttendanceByWeek()
        val poorIds = poorAttendanceByWeek.getAttendance(attendances)
        val mentees = menteeRepository.getAllMentees()

        return mentees.filter { it.id in poorIds }
    }

    fun generateTeamAttendanceReport(): Map<String, List<MenteeAttendance>> {
        val teams = teamRepository.getAllTeams()
        val mentees = menteeRepository.getAllMentees()
        val attendances = attendanceRepository.getAllAttendances()
        val teamAttendanceReportByWeek = TeamAttendanceReportByWeek()

        return teamAttendanceReportByWeek.generateReport(teams, mentees, attendances)
    }

}