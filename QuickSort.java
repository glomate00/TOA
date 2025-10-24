import java.util.Arrays;

public class QuickSort {

    static int comparisons = 0;
    static int swaps = 0;

    static void quickSort(int[] arr, int low, int high, int depth) {
        indent(depth); System.out.println("Виклик quickSort [" + low + "," + high + "]");
        if (low < high) {
            int p = partition(arr, low, high, depth);
            indent(depth); System.out.println("Після partition, опора на позиції " + p + ", масив = " + Arrays.toString(arr));
            quickSort(arr, low, p - 1, depth + 1);
            quickSort(arr, p + 1, high, depth + 1);
        } else {
            indent(depth); System.out.println("Підмасив довжини ≤ 1, повернення");
        }
    }

    static int partition(int[] arr, int low, int high, int depth) {
        int pivot = arr[high];
        indent(depth); System.out.println("  partition [" + low + "," + high + "], pivot=" + pivot + " (arr[" + high + "])");
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            indent(depth); System.out.print("    Порівняння arr[" + j + "]=" + arr[j] + " < pivot(" + pivot + ")? ");
            if (arr[j] < pivot) {
                i++;
                indent(depth); System.out.println("так -> swap(" + i + "," + j + ")");
                swap(arr, i, j, depth);
            } else {
                System.out.println("ні");
            }
        }

        indent(depth); System.out.println("  Переношу опору: swap(" + (i + 1) + "," + high + ")");
        swap(arr, i + 1, high, depth);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j, int depth) {
        if (i != j) {
            int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            swaps++;
            indent(depth); System.out.println("    Після swap: " + Arrays.toString(arr));
        } else {
            indent(depth); System.out.println("    swap пропущено (i==j): " + Arrays.toString(arr));
        }
    }

    static void indent(int d) { for (int k = 0; k < d; k++) System.out.print("    "); }

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};
        System.out.println("Початковий масив: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1, 0);
        System.out.println("Відсортований масив: " + Arrays.toString(arr));
        System.out.println("Порівнянь: " + comparisons);
        System.out.println("Перестановок: " + swaps);
    }
}
