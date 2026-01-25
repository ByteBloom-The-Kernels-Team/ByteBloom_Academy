import data.datasource.CsvEcosystemDataSource
import data.repository.AttendanceRepositoryImplementation
import data.repository.MenteeRepositoryImplementation
import data.repository.PerformanceSubmissionRepositoryImplementation
import data.repository.TeamRepositoryImplementation
import data.repository.ProjectRepositoryImplementation
import domain.usecase.*

fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    println("**************")

    val dataSource = CsvEcosystemDataSource()

    val menteeRepository = MenteeRepositoryImplementation(dataSource)
    val teamRepository = TeamRepositoryImplementation(dataSource)
    val attendanceRepository = AttendanceRepositoryImplementation(dataSource)
    val projectRepository = ProjectRepositoryImplementation(dataSource)

    val teamId = "t001"
    val teamName = "Team Alpha"

    println("\nTesting 10 Use Cases:")
    println("-------------------------------------------------------")

    val perfectAttendanceUC = CountMenteesWithPerfectAttendanceUseCase(attendanceRepository)
    val perfectCount = perfectAttendanceUC()
    println("1) Mentees with perfect attendance: $perfectCount")
    println("-------------------------------------------------------")

    val getAllMenteesUC = GetAllMenteesUseCase(menteeRepository)
    val allMentees = getAllMenteesUC()
    println("2) All Mentees: ${allMentees.joinToString()}")
    println("-------------------------------------------------------")

    val teamsNoProjectUC = FindTeamsWithNoProjectUseCase(teamRepository, projectRepository)
    val teamsWithoutProject = teamsNoProjectUC()
    println("3) Teams without projects: ${teamsWithoutProject.joinToString { it.name }}")
    println("-------------------------------------------------------")

    val teamNamesUC = GetTeamNamesUseCase(teamRepository)
    val teamNames = teamNamesUC()
    println("4) Team Names: ${teamNames.joinToString()}")
    println("-------------------------------------------------------")

    val searchMenteesUC = SearchMenteesByTeamNameUseCase(menteeRepository)
    val menteesInTeam = searchMenteesUC(teamName)
    println("5) Mentees in team '$teamName': ${menteesInTeam.joinToString { it.name }}")
    println("-------------------------------------------------------")

    val findProjectUseCase = FindProjectByTeamIdUseCase(projectRepository)
    val teamProject = findProjectUseCase(teamId)
    println("6) Project for $teamId: ${teamProject?.title ?: "No Project Assigned"}")
    println("-------------------------------------------------------")

    println("7) Team attendance report")
    val reportUseCase = GenerateTeamAttendanceReportUseCase(
        teamRepository,
        menteeRepository,
        attendanceRepository)
    val report = reportUseCase()
    report.forEach { (teamName, mentees) ->
        println("Team: $teamName")
        mentees.forEach { println(" - ${it.menteeName}: ${it.weekStatuses}") }
    }
    println("-------------------------------------------------------")

    println("8)Get All mentors.")
    val mentorsUseCase = GetAllMentorsUseCase(teamRepository)
    val mentorsList = mentorsUseCase()
    println("List of Mentors: ${mentorsList.distinct().joinToString()}")
    println("-------------------------------------------------------")

    println("9) Mentees with perfect scores counted")
    val perfectScoreUseCase = CountMenteesWithPerfectScoreUseCase(menteeRepository)
    val perfectScoreCount = perfectScoreUseCase()
    println("Number of mentees with at least one perfect score (100): $perfectScoreCount")
    println("-------------------------------------------------------")

    println("10) Poor attendance count.")
    val poorAttendanceUseCase = CountMenteesWithPoorAttendanceUseCase(attendanceRepository)
    val poorCount = poorAttendanceUseCase()
    println("Number of mentees with poor attendance (Absences or Lateness): $poorCount")
    println("-------------------------------------------------------")

    println("All 10 Use Cases executed successfully.")
}
