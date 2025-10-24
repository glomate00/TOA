import java.util.Arrays;

public class MergeSortRecursive {

    static int comparisons = 0;
    static int swaps = 0;
    static int step = 1;

    public static void mergeSort(int[] arr, int left, int right, int depth) {
        printIndent(depth);
        System.out.println(" Крок " + step++ + " | межі [" + left + ", " + right + "] : "
                + Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));

        if (left < right) {
            int mid = (left + right) / 2;

            printIndent(depth);
            System.out.println("↳ Поділ: ліва [" + left + ", " + mid + "] "
                    + Arrays.toString(Arrays.copyOfRange(arr, left, mid + 1))
                    + " | права [" + (mid + 1) + ", " + right + "] "
                    + Arrays.toString(Arrays.copyOfRange(arr, mid + 1, right + 1)));

            // Ліва рекурсія
            mergeSort(arr, left, mid, depth + 1);

            // Права рекурсія
            mergeSort(arr, mid + 1, right, depth + 1);

            // Злиття
            merge(arr, left, mid, right, depth);
        } else {
            printIndent(depth);
            System.out.println("⚬ Підмасив довжини 1, повернення: " +
                    Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int depth) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        printIndent(depth);
        System.out.println(" Злиття: " + Arrays.toString(L) + " + " + Arrays.toString(R));

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            comparisons++;
            printIndent(depth + 1);
            System.out.print("Порівняння " + L[i] + " ≤ " + R[j] + " → ");
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
                System.out.println("беремо " + arr[k - 1]);
            } else {
                arr[k++] = R[j++];
                System.out.println("беремо " + arr[k - 1]);
            }
            swaps++;
        }

        while (i < n1) {
            arr[k++] = L[i++];
            swaps++;
            printIndent(depth + 1);
            System.out.println("Додаємо залишок з L → " + arr[k - 1]);
        }

        while (j < n2) {
            arr[k++] = R[j++];
            swaps++;
            printIndent(depth + 1);
            System.out.println("Додаємо залишок з R → " + arr[k - 1]);
        }

        printIndent(depth);
        System.out.println("Після злиття [" + left + "," + right + "]: "
                + Arrays.toString(Arrays.copyOfRange(arr, left, right + 1))
                + " | порівнянь=" + comparisons + " перестановок=" + swaps);
    }

    private static void printIndent(int depth) {
        for (int i = 0; i < depth; i++) System.out.print("    ");
    }

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};

        System.out.println("Початковий масив: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1, 0);

        System.out.println("\n Результат:");
        System.out.println("Відсортований масив: " + Arrays.toString(arr));
        System.out.println("Загальна кількість порівнянь: " + comparisons);
        System.out.println("Загальна кількість перестановок: " + swaps);
    }
}
