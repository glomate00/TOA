import java.util.Arrays;

public class QuickSort {

    static int comparisons = 0;
    static int swaps = 0;

    public static void quickSort(int[] arr, int low, int high, int depth) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            System.out.println("Глибина " + depth + " | Опора " + arr[pivotIndex] + ": " + Arrays.toString(arr));
            quickSort(arr, low, pivotIndex - 1, depth + 1);
            quickSort(arr, pivotIndex + 1, high, depth + 1);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            swaps++;
            System.out.println("  Обмін: " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};
        System.out.println("Початковий масив: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1, 1);
        System.out.println("\nВідсортований масив: " + Arrays.toString(arr));
        System.out.println("\nКількість порівнянь: " + comparisons);
        System.out.println("Кількість перестановок: " + swaps);
    }
}
