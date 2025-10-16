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

GitHub Actions workflow (`.github/workflows/gradle.yml`) runs on:
- Push to `main` branch
- Pull requests to `main` branch

The CI pipeline includes two jobs:

**Build job** (runs on all pushes and PRs):
1. Validates Gradle wrapper integrity
2. Sets up JDK 17 (temurin distribution) with Gradle caching
3. Makes gradlew executable
4. Runs `./gradlew build --no-daemon --stacktrace`
5. Uploads build reports as artifacts on failure

**Dependency submission job** (runs only on pushes to main):
1. Generates and submits dependency graph for Dependabot alerts
2. Requires `contents: write` permission

## Gradle Configuration

- **Application Plugin**: Configured with `mainClass = 'MergeSort'` as default
- **Test Framework**: JUnit 5 (Jupiter) via JUnit BOM 5.10.0
- **Java Version**: Source/target compatibility set to Java 11
