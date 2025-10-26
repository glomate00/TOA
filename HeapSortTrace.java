public class HeapSortTrace {

    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};
        System.out.print("Початкова послідовність: ");
        printArray(arr);
        heapSort(arr);
        System.out.print("Відсортований масив: ");
        printArray(arr);
    }

    static void heapSort(int[] arr) {
        int n = arr.length;

        System.out.println("\n=== Побудова купи ===");
        // Побудова max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, true);
        }

        System.out.println("\n=== Вилучення елементів з купи ===");
        // Витягаємо елементи один за одним
        for (int i = n - 1; i >= 0; i--) {
            // Переносимо корінь (макс) у кінець
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.print("Після обміну кореня з arr[" + i + "]: ");
            printArray(arr);

            // Відновлюємо купу
            heapify(arr, i, 0, false);
        }
    }

    static void heapify(int[] arr, int n, int i, boolean building) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            System.out.print((building ? "Будуємо купу" : "Відновлюємо купу")
                    + " (i=" + i + ", largest=" + largest + "): ");
            printArray(arr);

            heapify(arr, n, largest, building);
        }
    }

    static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
