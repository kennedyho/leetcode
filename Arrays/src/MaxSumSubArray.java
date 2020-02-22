/* Find the maximum sum of a contiguous sub array in O(n) time complexity */

public class MaxSumSubArray {

    public int maxSum(int[] nums) {
        // Check edge case where the array parameter is null
        if (nums == null) {
            throw new NullPointerException("The array is null.");
        }

        // Initialized as the first number in the array
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            // Get the current maximum sum at the moment by comparing the current number with the sum of the
            // current max and the current number
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            // Get the overall maximum sum so far in the array
            maxSoFar = Math.max(currentMax, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        // Do unit tests here
    }
}
