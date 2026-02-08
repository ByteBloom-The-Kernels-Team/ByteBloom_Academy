# Code Review

**Team:** Code Hashira

We conducted a **Code Review** of the codebase. The goal of this review is to improve design quality, reduce complexity, and enhance testability and maintainability.

---

## Strengths

- Overall adherence to **Clean Architecture**, with a clear separation of layers.
- Use case and function naming clearly reflects their functional intent.
- Business logic is properly encapsulated within the **Domain layer** without leaking infrastructure concerns.

---

## Technical Notes

### CsvEcosystemDataSource

- The data source should be **injected** rather than instantiated directly, to reduce tight coupling and improve testability.
- It is recommended to add **validation within the Mapper and Parser** to ensure data integrity instead of blindly trusting incoming data.

### Domain Layer

- Avoid using **mutable lists** within the Domain layer, as they conflict with Functional Programming principles and may introduce unintended side effects.

### CountMenteesWithPerfectAttendanceUseCase & CountMenteesWithPerfectScoreUseCase

- The logic for `countPerfectScores` should be written directly inside `invoke` to improve readability and align with a clear Functional-Style approach.

### FindProjectByTeamIdUseCase

- The use case currently retrieves **only the first project** for a team, despite the possibility of multiple projects per team. This may lead to inaccurate results.

### GenerateTeamAttendanceReportUseCase

- Attendance data is fetched **separately for each team**, even though it could be retrieved once and reused. This results in unnecessary repetition and impacts performance.

### GetPerformanceBreakdownForMenteeUseCase

- Reduce unnecessary function layering where reuse is not required.
- Use a **data class** to represent performance data instead of returning multiple discrete values. This improves structure and reduces the likelihood of errors.

### GetTopMenteesByOverallScoreUseCase

- The total score should be computed **once** and stored in a variable prior to sorting, rather than recalculated during the sorting process, to improve performance.

### SearchMenteesByNameUseCase

- Fetching all mentees and then filtering introduces unnecessary overhead. Searching by name should be delegated to the `MenteeRepository` to reduce data load and adhere to the **Single Responsibility Principle**.

### SearchMenteesByTeamIdUseCase

- Filtering logic should reside within the `MenteeRepository`, not the use case. The repository is responsible for efficient data access and filtering, while the use case should focus on orchestrating application logic.

### GetTeamNamesUseCase

- Consider adding a **caching layer** if team names are relatively static. This reduces database load and improves response times.

----

**Best regards,**  
**Leave it to God**

