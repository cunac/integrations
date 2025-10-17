public class QuickSort {

    /**
     * Sorts an array of integers in ascending order using quick sort algorithm.
     *
     * @param arr the array to be sorted
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Recursive helper method for quick sort.
     *
     * @param arr the array to be sorted
     * @param low starting index of the partition
     * @param high ending index of the partition
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // Sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array around a pivot element.
     * Uses the last element as pivot and places all smaller elements to the left
     * and all greater elements to the right.
     *
     * @param arr the array to partition
     * @param low starting index of the partition
     * @param high ending index of the partition (pivot position)
     * @return the final position of the pivot element
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Prints the array elements.
     *
     * @param arr the array to print
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Main method demonstrating quick sort usage.
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 88, 45, 50};

        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
