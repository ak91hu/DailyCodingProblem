import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
      
        for (int i = 1; i < n; i++) {
            result[i] = nums[i - 1] * result[i - 1];
          
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5};
        int[] input2 = {3, 2, 1};

        System.out.println("Input1: " + Arrays.toString(input1));
        System.out.println("Output1: " + Arrays.toString(productExceptSelf(input1)));
        
        System.out.println("\nInput2: " + Arrays.toString(input2));
        System.out.println("Output2: " + Arrays.toString(productExceptSelf(input2)));
    }
}
