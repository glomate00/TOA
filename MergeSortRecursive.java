import java.util.Arrays;

public class MergeSortRecursive {

    static int comparisons = 0;
    static int swaps = 0;

    public static void mergeSort(int[] arr, int left, int right, int depth) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, depth + 1);
            mergeSort(arr, mid + 1, right, depth + 1);
            merge(arr, left, mid, right);
            System.out.println("Злиття (" + left + "," + right + "): " + Arrays.toString(arr));
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
            swaps++;
        }

        while (i < n1) { arr[k++] = L[i++]; swaps++; }
        while (j < n2) { arr[k++] = R[j++]; swaps++; }
    }

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};
        System.out.println("Початковий масив: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1, 1);
        System.out.println("\nВідсортований масив: " + Arrays.toString(arr));
        System.out.println("\nКількість порівнянь: " + comparisons);
        System.out.println("Кількість перестановок: " + swaps);
    }
}
