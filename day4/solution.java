import java.util.Arrays;

public class FirstMissingPositive {
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] input1 = {3, 4, -1, 1};
        System.out.println(findFirstMissingPositive(input1)); 
        
        int[] input2 = {1, 2, 0};
        System.out.println(findFirstMissingPositive(input2)); 

        int[] input3 = {7, 8, 9, 11, 12};
        System.out.println(findFirstMissingPositive(input3)); 
    }
}
