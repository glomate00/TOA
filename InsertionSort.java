public class InsertionSort {
    public static void main(String[] args) {
        int[] data = {47, 50, 61, 41, 53, 12, 68, 63, 3};

        System.out.println("Unsorted array:");
        for (int n : data) {
            System.out.print(n + " ");
        }
        System.out.println();

        insertionSort(data);

        System.out.println("Sorted array:");
        for (int n : data) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int pos = i - 1;
            while (pos >= 0 && nums[pos] > temp) {
                nums[pos + 1] = nums[pos];
                pos--;
            }
            nums[pos + 1] = temp;
        }
    }
}
