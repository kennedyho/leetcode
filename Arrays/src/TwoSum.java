/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.  */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mapOfComplements = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            // This is what we want to find from the array
            // Another value that can add up with this value to become the target number
            int complement = target - nums[i];
            // If the map contains the number we want to find
            // Get its index and along with the current index, return it as a pair in an array
            if (mapOfComplements.containsKey(complement)) {
                return new int[]{mapOfComplements.get(complement), i};
            }
            // Store the number as key and index as its value
            mapOfComplements.put(nums[i], i);
        }
        // If the complement is not found within the
        throw new IllegalArgumentException("No result found!");
    }

    // Main method for doing the unit tests
    public static void main(String[] args) {
        int[] testArray = {10, 20, 30, -30, -20, -10};

        System.out.println("Finding 50: " + Arrays.toString(twoSum(testArray, 50)));
    }
}
