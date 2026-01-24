import data.datasource.CsvEcosystemDataSource
import data.repository.AttendanceRepositoryImplementation
import data.repository.MenteeRepositoryImplementation
import data.repository.ProjectRepositoryImplementation
import data.repository.TeamRepositoryImplementation
import domain.strategy.team.TeamsWithoutProject
import domain.strategy.project.ProjectByTeamId
import domain.strategy.team.MentorPerTeam
import domain.strategy.attendance.PerfectAttendanceByWeek
import domain.strategy.attendance.PoorAttendanceByWeek

fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    println("**************")

    val dataSource = CsvEcosystemDataSource()

    val menteeRepository = MenteeRepositoryImplementation(dataSource)
    val teamRepository = TeamRepositoryImplementation(dataSource)
    val projectRepository = ProjectRepositoryImplementation(dataSource)
    val attendanceRepository = AttendanceRepositoryImplementation(dataSource)

    val ecosystemService = EcosystemService()

    val menteeId = "m002"
    val teamId = "t001"

    println("\nTesting 5 Features:")
    println("-------------------------------------------------------")

    println("1) Teams Without Projects:")
    val strategy = TeamsWithoutProject(teamRepository, projectRepository)
    val teamsWithoutProjects = ecosystemService.findTeamsWithoutProjects(strategy)
    println("• ${teamsWithoutProjects.joinToString { it.name }}")
    println("-------------------------------------------------------")

    println("2) Project Assigned to Team ($teamId):")
    val projectStrategy = ProjectByTeamId(projectRepository)
    val project = ecosystemService.findProjectAssignedToTeam(teamId, projectStrategy)
    println("• ${project?.title ?: "No Project Assigned"}")
    println("-------------------------------------------------------")

    println("3) Lead Mentor for Mentee ($menteeId):")
    val mentorStrategy = MentorPerTeam(menteeRepository, teamRepository)
    val mentor = ecosystemService.findLeadMentorForMentee(menteeId, mentorStrategy)
    println("• ${mentor ?: "Not Assigned"}")
    println("-------------------------------------------------------")

    println("4) Mentees With Perfect Attendance:")
    val perfectStrategy = PerfectAttendanceByWeek(attendanceRepository, menteeRepository)
    val perfect = ecosystemService.getMenteesWithPerfectAttendance(perfectStrategy)
    println("• ${if (perfect.isEmpty()) "None" else perfect.joinToString { it.name }}")
    println("-------------------------------------------------------")

    println("5) Mentees With Poor Attendance:")
    val poorStrategy = PoorAttendanceByWeek(attendanceRepository, menteeRepository)
    val poor = ecosystemService.getMenteesWithPoorAttendance(poorStrategy)
    println("• ${if (poor.isEmpty()) "None" else poor.joinToString { it.name }}")
    println("-------------------------------------------------------")
}

