import data.parseMenteeData
import data.parsePerformanceData
import data.parseTeamData

fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    println("✅ Project setup is correct and runnable.")
    println("******************************************************")

    println("\n--->>> ByteBloom Ecosystem - Data Parsing Demo <<<---\n")
    println("\n--->>> Weaving The Domain Graph <<<---\n")

    val teamRawDataRead  = parseTeamData()
    val menteeRawDataRead  = parseMenteeData()
    val performanceRawDataRead  = parsePerformanceData()

    val domainBuilderService = DomainBuilder(
        teamRawDataRead,
        menteeRawDataRead,
        performanceRawDataRead)

    val domainTeamsBuilt = domainBuilderService.buildDomain()

    val teamSelectedForPrinting = domainTeamsBuilt.firstOrNull()
    // Another way to select a team by ID
    // val teamSelectedForPrinting = domainTeamsBuilt.find { it.id == "bravo" }

    if (teamSelectedForPrinting == null) {
        println("--->>> No teams were found in the data!")
        return
    }

    println("=================================================")
    println("\n--->>> Selected Team Details <<<---")
    println("--->>> Team Name: ${teamSelectedForPrinting.name}")
    println("--->>> Mentor: ${teamSelectedForPrinting.mentor}")
    println("\n=================================================")
    println("\n--->>> Mentees linked to this team <<<---")
    if (teamSelectedForPrinting.mentees.isEmpty()) {
        println("--->>> No mentees are linked to this team!")
    } else {
        teamSelectedForPrinting.mentees.forEach { mentee ->
            println("   - Mentee: ${mentee.name} (ID: ${mentee.id})")
        }
    }
    println("\n=================================================")
}

