/* Find the maximum product of a contiguous sub array in O(n) time complexity */

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {

        // Check the edge case
        if (nums == null) {
            throw new NullPointerException("Invalid null array parameter.");
        }

        // initialize as the first number in the sub array
        int maxSoFar = nums[0];     // overall maximum product so far
        int currentMax = nums[0];   // maximum product as of now
        int currentMin = nums[0];   // minimum product as of now

        for (int i = 1; i < nums.length; ++i) {
            // Deal with negative number in the array.
            // When a smaller number gets multiplied with a negative number, it becomes the bigger one.
            // When a bigger number gets multiplied with a negative number, it becomes the smaller one.
            if (nums[i] < 0) {
                // Swap the currentMax and the currentMin because their identity is about to change when multiplied with the negative number later.
                int tempMax = currentMax;
                currentMax = currentMin;
                currentMin = tempMax;
            }

            // Use similar method as max sum of of sub array except we need both current maximum and minimum
            // Maximum number is to keep track of the current maximum to be compared with the maximum so far.
            currentMax = Math.max(currentMax * nums[i], nums[i]);
            // Minimum number is needed to keep track of the case where the number is smaller at that moment but then when it is multipled
            // with a negative number, it suddenly becomes the bigger number.
            currentMin = Math.min(currentMin * nums[i], nums[i]);

            // Get the overall maximum product so far by comparing it with the current max number
            maxSoFar = Math.max(currentMax, maxSoFar);
        }

        return maxSoFar;
    }

    // Do unit tests here
    public static void main(String[] args) {
        int[] test1 = {0, 0, 1, 2};
        int[] test2 = {3, -1, 4};
        int[] test3 = {-2, -1, 0, 2};
        int[] test5 = {-5, -6, -7, 8};
    }

}
