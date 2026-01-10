package service

import domain.strategy.team.TeamSelectionStrategy
import domain.model.Mentee
import domain.model.MenteeAttendance
import domain.model.Project
import domain.model.Team
import domain.model.SubmissionType
import domain.strategy.attendance.AttendanceStrategy
import domain.strategy.attendance.TeamAttendanceReportStrategy
import domain.strategy.performance.MenteePerformanceAnalyzer
import domain.strategy.performance.TeamPerformanceStrategy
import domain.strategy.performance.TopScoringMenteeStrategy
import domain.strategy.project.ProjectSelectionStrategy
import domain.strategy.team.MentorSearchStrategy

class EcosystemService {
    fun findTeamsWithoutProjects(
        teamSelectionStrategy: TeamSelectionStrategy
    ): List<Team> = teamSelectionStrategy.selectTeams()

    fun findProjectAssignedToTeam(
        teamId: String,
        projectSelectionStrategy: ProjectSelectionStrategy
    ): Project? = projectSelectionStrategy.findProjectForTeam(teamId)

    fun findLeadMentorForMentee(
        menteeId: String,
        mentorSearchStrategy: MentorSearchStrategy
    ): String? = mentorSearchStrategy.findMentorForMentee(menteeId)

    fun getTeamPerformanceAverage(
        teamId: String,
        teamPerformance: TeamPerformanceStrategy
    ): Double = teamPerformance.calculateAverage(teamId)

    fun getPerformanceBreakdownForMentee(
        menteeId: String,
        performanceAnalyzer: MenteePerformanceAnalyzer
    ): Map<SubmissionType, List<Double>> = performanceAnalyzer.menteeAnalyze(menteeId)

    fun getMenteesWithPerfectAttendance(
        attendanceStrategy: AttendanceStrategy
    ): List<Mentee> = attendanceStrategy.getAttendance()

    fun getMenteesWithPoorAttendance(
        attendanceStrategy: AttendanceStrategy
    ): List<Mentee> = attendanceStrategy.getAttendance()

    fun generateTeamAttendanceReport(
        reportStrategy: TeamAttendanceReportStrategy
    ): Map<String, List<MenteeAttendance>> = reportStrategy.generateReport()

    fun getTopScoringMentee(
        topScoringMenteeStrategy: TopScoringMenteeStrategy
    ): Mentee? = topScoringMenteeStrategy.findTopMentee()
}