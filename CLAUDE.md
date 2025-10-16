# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Gradle-based Java project demonstrating sorting algorithm implementations (Bubble Sort and Merge Sort). The project uses Java 11 as the source/target compatibility but CI runs on JDK 17.

## Build & Development Commands

### Building
```bash
./gradlew build          # Build the project
./gradlew clean          # Clean build artifacts
./gradlew classes        # Compile classes only
```

### Running
```bash
./gradlew run                        # Run MergeSort (default main class)
./gradlew run --args='BubbleSort'   # Run BubbleSort
```

Alternatively, compile and run directly:
```bash
./gradlew classes
java -cp build/classes/java/main MergeSort
java -cp build/classes/java/main BubbleSort
```

### Testing
```bash
./gradlew test           # Run all tests
./gradlew test --tests ClassName        # Run specific test class
./gradlew test --tests ClassName.methodName  # Run specific test method
```

### Code Coverage
```bash
./gradlew test jacocoTestReport              # Generate coverage report
./gradlew jacocoTestCoverageVerification    # Verify coverage thresholds
```

Coverage reports are generated in:
- HTML: `build/reports/jacoco/test/html/index.html`
- XML: `build/reports/jacoco/test/jacocoTestReport.xml`
- CSV: `build/reports/jacoco/test/jacocoTestReport.csv`

Coverage thresholds:
- Overall minimum: 80%
- Per-class line coverage minimum: 70%

## Architecture

### Code Structure
- **Sorting Implementations**: Each sorting algorithm is implemented as a standalone class with a `main()` method for demonstration purposes
- **Static Methods**: Both BubbleSort and MergeSort expose their core sorting logic as public static methods that can be called from other code
- **Boundary Handling**: Both implementations include null and length checks to handle edge cases

### Algorithm Implementations

**BubbleSort** (`src/main/java/BubbleSort.java`):
- Optimized with early termination when no swaps occur
- Time complexity: O(n²) worst case, O(n) best case (already sorted)

**MergeSort** (`src/main/java/MergeSort.java`):
- Uses a temporary array allocated once at the top level
- Divide-and-conquer recursive implementation
- Time complexity: O(n log n) in all cases

## CI/CD

### Main CI Workflow (`.github/workflows/gradle.yml`)

Runs on push to `main` and pull requests to `main`.

**Build job**:
1. Validates Gradle wrapper integrity
2. Sets up JDK 17 with Gradle caching
3. Runs: `./gradlew build test jacocoTestReport jacocoTestCoverageVerification`
4. Publishes test reports with dorny/test-reporter
5. Adds coverage report to PR comments (madrapps/jacoco-report)
6. Uploads artifacts: build reports (on failure), coverage HTML (always)
7. Generates coverage badges and uploads to Codecov

**Trigger-autofix job** (runs if build fails):
- Calls the autofix workflow with failure details
- Passes failed job name, run URL, branch, and SHA

**Dependency submission job** (runs only on pushes to main):
- Generates and submits dependency graph for Dependabot alerts

### Auto-Fix Workflow (`.github/workflows/autofix.yml`)

Separate workflow triggered by CI failures or manually via workflow_dispatch.

**Auto-fix job**:
1. Checks for OPENAI_API_KEY secret (gracefully skips if not set)
2. Checks out code at the failing commit
3. Uses OpenAI Codex to analyze failures and generate fixes
4. Verifies fix by running tests and coverage checks
5. Creates PR with automatic fixes to the failing branch

**Triggers:**
- Called by CI workflow when build job fails
- Manual dispatch via GitHub Actions UI

## Gradle Configuration

- **Application Plugin**: Configured with `mainClass = 'MergeSort'` as default
- **Test Framework**: JUnit 5 (Jupiter) via JUnit BOM 5.10.0
- **Java Version**: Source/target compatibility set to Java 11
- **JaCoCo Plugin**: Version 0.8.11 for code coverage analysis
  - Test reports automatically generated after running tests
  - Coverage verification enforces 80% overall and 70% per-class minimums
