public class InsertionSort {
    public static void main(String[] args) {
        int[] data = {69, 52, 97, 27, 10, 88,29, 1, 24};

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
