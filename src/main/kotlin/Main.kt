import data.datasource.CsvEcosystemDataSource
import data.repository.AttendanceRepositoryImplementation
import data.repository.MenteeRepositoryImplementation
import data.repository.PerformanceSubmissionRepositoryImplementation
import data.repository.ProjectRepositoryImplementation
import data.repository.TeamRepositoryImplementation
import domain.strategy.team.TeamsWithoutProject
import service.EcosystemService

fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    println("**************")

    val dataSource = CsvEcosystemDataSource()

    val menteeRepository = MenteeRepositoryImplementation(dataSource)
    val performanceSubmissionRepository = PerformanceSubmissionRepositoryImplementation(dataSource)
    val teamRepository = TeamRepositoryImplementation(dataSource)
    val projectRepository = ProjectRepositoryImplementation(dataSource)
    val attendanceRepository = AttendanceRepositoryImplementation(dataSource)

    val ecosystemService = EcosystemService(
        teamRepository,
        menteeRepository,
        projectRepository,
        attendanceRepository,
        performanceSubmissionRepository
    )

    val menteeId = "m002"
    val teamId = "t001"

    println("\nTesting 5 Features:")
    println("-------------------------------------------------------")

    println("1) Teams Without Projects:")
    val strategy = TeamsWithoutProject()
    val teamsWithoutProjects = ecosystemService.findTeamsWithoutProjects(strategy)
    println("• ${teamsWithoutProjects.joinToString { it.name }}")
    println("-------------------------------------------------------")

    println("2) Project Assigned to Team ($teamId):")
    val project = ecosystemService.findProjectAssignedToTeam(teamId)
    println("• ${project?.title ?: "No Project Assigned"}")
    println("-------------------------------------------------------")

    println("3) Lead Mentor for Mentee ($menteeId):")
    val mentor = ecosystemService.findLeadMentorForMentee(menteeId)
    println("• ${mentor ?: "Not Assigned"}")
    println("-------------------------------------------------------")

    println("4) Mentees With Perfect Attendance:")
    val perfect = ecosystemService.getMenteesWithPerfectAttendance()
    println("• ${if (perfect.isEmpty()) "None" else perfect.joinToString { it.name }}")
    println("-------------------------------------------------------")

    println("5) Mentees With Poor Attendance:")
    val poor = ecosystemService.getMenteesWithPoorAttendance()
    println("• ${if (poor.isEmpty()) "None" else poor.joinToString { it.name }}")
    println("-------------------------------------------------------")
}

