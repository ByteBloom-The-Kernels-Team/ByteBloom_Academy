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

}