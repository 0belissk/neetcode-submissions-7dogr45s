class Solution {
    public int search(int[] nums, int target) {
        int mid = nums.length / 2;
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

            mid = l + (r - l) / 2;
        }

        return -1;
    }
}
