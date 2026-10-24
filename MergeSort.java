import java.util.Arrays;
import java.util.Scanner;

/**
 * Merge Sort: a command-line version of the MergeSort Lab project.
 * Run: javac MergeSort.java && java MergeSort
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MergeSort Lab: Java Demo ===");
        System.out.println("Enter numbers separated by spaces (example: 38 12 27 43 9):");
        String line = scanner.nextLine().trim();

        if (line.isEmpty()) {
            System.out.println("No numbers entered.");
            scanner.close();
            return;
        }

        String[] parts = line.split("\\s+");
        int[] values = new int[parts.length];

        try {
            for (int i = 0; i < parts.length; i++) {
                values[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter whole numbers only.");
            scanner.close();
            return;
        }

        System.out.println("Original array: " + Arrays.toString(values));
        mergeSort(values, 0, values.length - 1);
        System.out.println("Sorted array:   " + Arrays.toString(values));
        System.out.println("Time complexity: O(n log n)");
        System.out.println("Typical extra space: O(n)");
        scanner.close();
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int n = 0; n < temp.length; n++) {
            arr[left + n] = temp[n];
        }
    }
}
