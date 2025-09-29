public class SelectionSort {
    public static void main(String[] args) {
        int[] data = {47, 50, 61, 41, 53, 12, 68, 63, 3};

        System.out.println("Unsorted array:");
        for (int n : data) {
            System.out.print(n + " ");
        }
        System.out.println();

        selectionSort(data);

        System.out.println("Sorted array:");
        for (int n : data) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minPos]) {
                    minPos = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minPos];
            nums[minPos] = tmp;
        }
    }
}
