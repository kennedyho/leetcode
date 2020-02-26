/* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array. */

public class FindMinInRotatedSortedArray {
    // Easiest way is Brute Force in O(n)
    // Fastest way is to use Binary Search and modify it to get O(log(n)) time complexity
    private static int findMin(int[] nums) {
        // Edge case for null param
        if (nums == null) {
            throw new NullPointerException("Array parameter is null.");
        }

        // If there is only one item in the array
        if (nums.length == 1) {
            return nums[0];     // the only item is the minimum
        }

        // Pointer left and right for binary searching
        int left = 0;                     // initialized to point to first index
        int right = nums.length - 1;      // initialized to point to last index

        // If the first item is smaller than the last item, this means the array is not rotated at all
        // The array is sorted perfectly from small to large
        if (nums[left] < nums[right]) {
            return nums[0];
        }

        // Modified binary search
        while (left <= right) {
            // Get the middle index
            int mid = left + (right - left) / 2;

            // Check for the inflection point
            // Inflection points means the point where the array is rotated
            // If the middle item is bigger than its next item, this means the next item is the minimum
            // This has to come first because if there is only two items, mid will be 0 and mid + 1 will be 1.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // If the middle item is smaller than its previous item, this means it is the minimum
            // This has to come second because if there is only two items, mid - 1 will cause index out of bounds exception
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // Decides to search from the left or right
            // If middle item is smaller than the first item, this means that the minimum is on the left
            if (nums[mid] < nums[0]) {
                right = mid - 1;    // Search in the left half
                // If middle item is bigger than the first item, this means that the minimum is on the right
            } else {
                left = mid + 1;     // Search in the right half
            }
        }
        return -1;
    }

    // Do your unit tests here
    private static void main(String[] args) {

    }

}
