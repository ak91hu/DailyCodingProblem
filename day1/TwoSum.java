import java.util.HashSet;
import java.util.Scanner;

public class TwoSum {
    public static boolean hasTwoSum(int[] numbers, int k) {
        var seen = new HashSet<Integer>();

        for (int number : numbers) {
            if (seen.contains(k - number)) {
                return true;
            }
            seen.add(number);
        }
        return false;
    }

    public static void main(String[] args) {
        var list = new int[]{10, 15, 3, 7};
        var scanner = new Scanner(System.in);

        System.out.print("Enter the target number (k): ");
        if (scanner.hasNextInt()) {
            var k = scanner.nextInt();
            var result = hasTwoSum(list, k);
            System.out.println("Pair found: " + result);
        } else {
            System.out.println("Error: Please enter a valid integer.");
        }
        
        scanner.close();
    }
}
