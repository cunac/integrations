import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("MergeSort Tests")
class MergeSortTest {

    static Stream<Arguments> provideSortingTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{64, 34, 25, 12, 22, 11, 90, 88, 45, 50},
                        new int[]{11, 12, 22, 25, 34, 45, 50, 64, 88, 90},
                        "unsorted array"
                ),
                Arguments.of(
                        new int[]{5, 2, 8, 1, 9},
                        new int[]{1, 2, 5, 8, 9},
                        "random unsorted array"
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{1, 2, 3, 4, 5},
                        "already sorted array"
                ),
                Arguments.of(
                        new int[]{5, 4, 3, 2, 1},
                        new int[]{1, 2, 3, 4, 5},
                        "reverse sorted array"
                ),
                Arguments.of(
                        new int[]{42},
                        new int[]{42},
                        "single element array"
                ),
                Arguments.of(
                        new int[]{},
                        new int[]{},
                        "empty array"
                ),
                Arguments.of(
                        new int[]{3, 3, 3, 3},
                        new int[]{3, 3, 3, 3},
                        "all elements same"
                ),
                Arguments.of(
                        new int[]{-5, -1, -10, 0, 3},
                        new int[]{-10, -5, -1, 0, 3},
                        "array with negative numbers"
                ),
                Arguments.of(
                        new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0},
                        new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE},
                        "array with boundary values"
                )
        );
    }

    @ParameterizedTest(name = "shouldSortArrayCorrectly - {2}")
    @MethodSource("provideSortingTestCases")
    @DisplayName("Should sort array correctly")
    void shouldSortArrayCorrectly(int[] input, int[] expected, String testCase) {
        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input, "Failed for: " + testCase);
    }

    @ParameterizedTest(name = "shouldHandleNullArray")
    @MethodSource("provideNullTestCase")
    @DisplayName("Should handle null array gracefully")
    void shouldHandleNullArray(int[] input) {
        MergeSort.mergeSort(input);
        assertNull(input, "Null array should remain null");
    }

    static Stream<Arguments> provideNullTestCase() {
        return Stream.of(Arguments.of((int[]) null));
    }

    @ParameterizedTest(name = "shouldSortArrayWithDuplicates - {2}")
    @MethodSource("provideDuplicateTestCases")
    @DisplayName("Should sort array with duplicates correctly")
    void shouldSortArrayWithDuplicates(int[] input, int[] expected, String testCase) {
        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input, "Failed for: " + testCase);
    }

    static Stream<Arguments> provideDuplicateTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{5, 2, 8, 2, 9, 5},
                        new int[]{2, 2, 5, 5, 8, 9},
                        "array with duplicate values"
                ),
                Arguments.of(
                        new int[]{1, 1, 1, 2, 2},
                        new int[]{1, 1, 1, 2, 2},
                        "array with multiple duplicates"
                )
        );
    }

    @ParameterizedTest(name = "shouldSortTwoElementArray - {2}")
    @MethodSource("provideTwoElementTestCases")
    @DisplayName("Should sort two element arrays correctly")
    void shouldSortTwoElementArray(int[] input, int[] expected, String testCase) {
        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input, "Failed for: " + testCase);
    }

    static Stream<Arguments> provideTwoElementTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 1},
                        new int[]{1, 2},
                        "two elements unsorted"
                ),
                Arguments.of(
                        new int[]{1, 2},
                        new int[]{1, 2},
                        "two elements already sorted"
                )
        );
    }

    @ParameterizedTest(name = "shouldSortLargeArray - {2}")
    @MethodSource("provideLargeArrayTestCases")
    @DisplayName("Should sort large arrays efficiently")
    void shouldSortLargeArray(int[] input, int[] expected, String testCase) {
        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input, "Failed for: " + testCase);
    }

    static Stream<Arguments> provideLargeArrayTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
                        new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                        "larger reverse sorted array"
                )
        );
    }
}
