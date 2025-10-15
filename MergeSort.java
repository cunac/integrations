public class MergeSort {

    /**
     * Sorts an array of integers in ascending order using merge sort algorithm.
     *
     * @param arr the array to be sorted
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    /**
     * Recursive helper method for merge sort.
     *
     * @param arr the array to be sorted
     * @param temp temporary array for merging
     * @param left left index of the subarray
     * @param right right index of the subarray
     */
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort left half
            mergeSort(arr, temp, left, mid);

            // Sort right half
            mergeSort(arr, temp, mid + 1, right);

            // Merge the sorted halves
            merge(arr, temp, left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays into one sorted subarray.
     *
     * @param arr the array containing the subarrays
     * @param temp temporary array for merging
     * @param left left index of the first subarray
     * @param mid right index of the first subarray
     * @param right right index of the second subarray
     */
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy elements to temp array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;        // Index for left subarray
        int j = mid + 1;     // Index for right subarray
        int k = left;        // Index for merged array

        // Merge the two subarrays
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from left subarray
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // Note: No need to copy remaining elements from right subarray
        // as they are already in their correct position
    }

    /**
     * Prints the array elements.
     *
     * @param arr the array to print
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Main method demonstrating merge sort usage.
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 88, 45, 50};

        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
