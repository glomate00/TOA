import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high, int depth) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            System.out.println("Глибина " + depth + " | Після розбиття (опора = " + arr[pivotIndex] + "): " + Arrays.toString(arr));
            quickSort(arr, low, pivotIndex - 1, depth + 1);
            quickSort(arr, pivotIndex + 1, high, depth + 1);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println("  Обмін: " + Arrays.toString(arr));
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        System.out.println("  Перенесення опори: " + Arrays.toString(arr));
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};
        System.out.println("Початковий масив: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1, 1);
        System.out.println("\nВідсортований масив: " + Arrays.toString(arr));
    }
}
