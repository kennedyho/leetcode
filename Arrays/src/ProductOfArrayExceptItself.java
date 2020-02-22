/* Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the
product of all the elements of nums except nums[i].
Note: Please solve it without division and in O(n).
*/

import java.util.Arrays;

public class ProductOfArrayExceptItself {
    // Use the left and right sub array method
    // Create two arrays: 1 to manage left sub array product, 1 to manage right sub array product
    private static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        // Create left product array
        // Ascending order
        output[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            output[i] = nums[i - 1] * output[i - 1];
        }

        // Create the right product array
        // Descending order
        int rightProduct = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            rightProduct *= nums[i + 1];
            output[i] *= rightProduct;
        }
        return output;
    }

    // unit testing
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
