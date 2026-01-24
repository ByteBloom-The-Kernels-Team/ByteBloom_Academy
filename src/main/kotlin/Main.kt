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
    val performanceRepository = PerformanceSubmissionRepositoryImplementation(dataSource)
    val attendanceRepository = AttendanceRepositoryImplementation(dataSource)
    val projectRepository = ProjectRepositoryImplementation(dataSource)

    val teamId = "t001"
    val teamName = "Team Alpha"

    println("\nTesting 5 Use Cases:")
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

    println("All 5 Use Cases executed successfully.")
}
