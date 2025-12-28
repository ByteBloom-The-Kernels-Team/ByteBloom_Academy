# The ByteBloom Ecosystem - Official Project Starter

Welcome to the official starter project for the ByteBloom Academy's Kotlin Software Engineering mentorship program. This domain.repository contains the foundational code and data assets for your team's main project.

## Project Vision

The goal of this project is to build a robust, well-tested, and professionally architected command-line application. This system will process data from multiple sources to model a mentee ecosystem, generating insightful reports based on user commands. This project is the canvas on which you will apply all the concepts learned during the 8-week program, from basic syntax to SOLID principles, TDD, and concurrency.

## Getting Started

1.  **Clone This Starter Project:** Use `git clone` to download this starter project to your local machine.
2.  **Open in IntelliJ IDEA:** Open the cloned project folder in IntelliJ. It will automatically detect and sync the `build.gradle.kts` file.
3.  **Run the `main` function:** Navigate to `src/main/kotlin/Main.kt` and run the `main` function to confirm your setup is correct.

## Project Structure

-   `src/main/kotlin/Main.kt`: The main entry point for the application.
-   `src/main/resources/`: Contains all raw data files (`mentees.csv`, `teams.csv`, `performance.csv`).
-   `src/test/kotlin/`: This directory is where all your unit tests will live.
-   `build.gradle.kts`: The heart of the project. This file manages dependencies (like JUnit, Koin, etc.) and build settings.
-   `.gitignore`: Specifies which files and directories to ignore in version control.
-   `README.md`: This file! The primary documentation for the project.

-   ## Week 3 Additions

During this week, we extended the starter project with new functionality to process and connect raw data into meaningful domain objects. These additions demonstrate the application of design principles and prepare the foundation for future reporting features.

### New Components

-   *Parser Functions:* Added reusable functions (parseTeamData, parseMenteeData, parsePerformanceData) to read and transform raw CSV files into structured data classes (TeamRaw, MenteeRaw, PerformanceRaw).
-   *DomainBuilder service:* Implemented the DomainBuilder class to construct the final domain model:
    -   Builds Team objects from raw data.
    -   Maps Mentee objects to their respective teams.
    -   Links PerformanceSubmission records to each mentee.
-   *Main Program Update:* Simplified Main.kt to:
    -   Use parser functions instead of manual file reading.
    -   Build the complete domain ecosystem with DomainBuilder.
    -   Select and print the first team from the list, showing its mentor and linked mentees.
    -   Provide an alternative (commented) option to select a team by ID.

### Outcome

-   The system now demonstrates a working *Observer-like relationship* between teams and mentees, where teams act as subjects and mentees are linked observers.
-   Output is clear and professional, displaying team details and associated mentees in a structured format.
-   Codebase is cleaner, with consistent naming conventions and reusable components.

-   ---

### The Kernels Team

💙💙 **Keep Creating** 💙💙
