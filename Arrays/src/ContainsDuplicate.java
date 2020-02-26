/* Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct. */

import java.util.HashSet;

public class ContainsDuplicate {
    private static boolean containsDuplicate(int[] nums) {
        // Use a hashset to obtain O(n) time complexity
        // Accessing an item in the hashset is O(1) time complexity
        // However, more memory will be used to maintain another set of N numbers.
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    // Unit test
    public static void main(String[] args) {

    }
}
