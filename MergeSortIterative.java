import java.util.Arrays;

public class MergeSortIterative {

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int step = 1;

        for (int currSize = 1; currSize < n; currSize *= 2) {
            System.out.println("\nКрок розміру " + currSize + ":");
            for (int left = 0; left < n - 1; left += 2 * currSize) {
                int mid = Math.min(left + currSize - 1, n - 1);
                int right = Math.min(left + 2 * currSize - 1, n - 1);
                merge(arr, left, mid, right);
                System.out.println("Ітерація " + step++ + " (" + left + "-" + right + "): " + Arrays.toString(arr));
            }
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};
        System.out.println("Початковий масив: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("\nВідсортований масив: " + Arrays.toString(arr));
    }
}
