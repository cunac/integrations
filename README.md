# Integrations

A Java project demonstrating sorting algorithms including Bubble Sort and Merge Sort.

## Project Structure

This is a Gradle-based Java project with the following structure:

```
integrations/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── BubbleSort.java
│   │       └── MergeSort.java
│   └── test/
│       └── java/
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
└── gradle/
    └── wrapper/
```

## Prerequisites

- Java 11 or higher
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

Or compile and run directly with Java:

```bash
# Compile
./gradlew classes

# Run MergeSort
java -cp build/classes/java/main MergeSort

# Run BubbleSort
java -cp build/classes/java/main BubbleSort
```

## Available Gradle Tasks

- `./gradlew build` - Build the project
- `./gradlew clean` - Clean build artifacts
- `./gradlew run` - Run the application
- `./gradlew test` - Run tests
- `./gradlew tasks` - List all available tasks

## Algorithms Included

### Bubble Sort
A simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.

### Merge Sort
An efficient, stable sorting algorithm that uses a divide-and-conquer approach to sort elements.
