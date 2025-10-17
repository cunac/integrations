# Integrations

[![CI Build](https://github.com/cunac/integrations/workflows/Java%20CI%20with%20Gradle/badge.svg)](https://github.com/cunac/integrations/actions)
[![codecov](https://codecov.io/gh/cunac/integrations/branch/main/graph/badge.svg)](https://codecov.io/gh/cunac/integrations)

A Java project demonstrating sorting algorithms including Bubble Sort, Merge Sort, and Quick Sort.

## Project Structure

This is a Gradle-based Java project with the following structure:

```
integrations/
├── .github/
│   └── workflows/
│       ├── gradle.yml          # Main CI/CD pipeline
│       └── autofix.yml         # Automated fix workflow
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── BubbleSort.java
│   │       ├── MergeSort.java
│   │       └── QuickSort.java
│   └── test/
│       └── java/
│           ├── BubbleSortTest.java
│           ├── MergeSortTest.java
│           └── QuickSortTest.java
├── build.gradle
├── settings.gradle
├── CLAUDE.md               # AI assistant instructions
├── gradlew
├── gradlew.bat
└── gradle/
    └── wrapper/
```

## Prerequisites

- Java 11 or higher (CI runs on JDK 17)
- Gradle wrapper is included (no need to install Gradle separately)

## Building the Project

To build the project, run:

```bash
./gradlew build
```

## Running the Applications

### Run MergeSort (default main class):
```bash
./gradlew run
```

### Run BubbleSort:
```bash
./gradlew run --args='BubbleSort'
```

### Run QuickSort:
```bash
./gradlew run --args='QuickSort'
```

Or compile and run directly with Java:

```bash
# Compile
./gradlew classes

# Run MergeSort
java -cp build/classes/java/main MergeSort

# Run BubbleSort
java -cp build/classes/java/main BubbleSort

# Run QuickSort
java -cp build/classes/java/main QuickSort
```

## Available Gradle Tasks

- `./gradlew build` - Build the project
- `./gradlew clean` - Clean build artifacts
- `./gradlew run` - Run the application
- `./gradlew test` - Run tests
- `./gradlew jacocoTestReport` - Generate code coverage report
- `./gradlew jacocoTestCoverageVerification` - Verify coverage thresholds (80% overall, 70% per-class)
- `./gradlew tasks` - List all available tasks

## Algorithms Included

### Bubble Sort
A simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
- **Time Complexity**: O(n²) worst case, O(n) best case (already sorted)
- **Space Complexity**: O(1)
- **Stable**: Yes
- **Features**: Optimized with early termination when no swaps occur

### Merge Sort
An efficient, stable sorting algorithm that uses a divide-and-conquer approach to sort elements.
- **Time Complexity**: O(n log n) in all cases
- **Space Complexity**: O(n)
- **Stable**: Yes
- **Features**: Uses a temporary array allocated once at the top level

### Quick Sort
An efficient divide-and-conquer sorting algorithm that selects a pivot element and partitions the array around it.
- **Time Complexity**: O(n log n) average case, O(n²) worst case
- **Space Complexity**: O(log n) due to recursion
- **Stable**: No
- **Features**: In-place sorting with last element as pivot

## Testing

The project includes comprehensive JUnit 5 test suites for all sorting algorithms:

```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests BubbleSortTest
./gradlew test --tests MergeSortTest
./gradlew test --tests QuickSortTest

# Run specific test method
./gradlew test --tests QuickSortTest.testSortRandomArray
```

## Code Coverage

The project uses JaCoCo for code coverage analysis with the following thresholds:
- **Overall minimum**: 80%
- **Per-class line coverage minimum**: 70%

Generate and view coverage reports:

```bash
# Generate coverage report
./gradlew test jacocoTestReport

# Verify coverage thresholds
./gradlew jacocoTestCoverageVerification
```

Coverage reports are generated in:
- HTML: `build/reports/jacoco/test/html/index.html`
- XML: `build/reports/jacoco/test/jacocoTestReport.xml`
- CSV: `build/reports/jacoco/test/jacocoTestReport.csv`

## CI/CD

This project uses GitHub Actions for continuous integration and deployment:

### Main CI Workflow
Runs on all pushes to `main` and pull requests:
- Validates Gradle wrapper integrity
- Builds the project with JDK 17
- Runs all tests with JUnit 5
- Generates and verifies code coverage with JaCoCo
- Publishes test reports and coverage results
- Uploads coverage to Codecov
- Submits dependency graph for Dependabot

### Auto-Fix Workflow
Automatically triggered when the main CI build fails:
- Analyzes test failures and build errors
- Uses OpenAI Codex to generate fixes
- Verifies fixes by running tests
- Creates pull requests with automatic fixes

To enable auto-fix workflow, set the `OPENAI_API_KEY` secret in your repository settings.

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

Ensure all tests pass and coverage thresholds are met before submitting a PR.

## License

This project is open source and available for educational purposes.
