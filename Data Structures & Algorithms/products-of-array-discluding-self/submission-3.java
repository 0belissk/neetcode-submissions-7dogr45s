class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);

        int placeHolder = 1;

        // left products
        for (int i = 0; i < nums.length; i++) {
            arr[i] *= placeHolder;
            placeHolder *= nums[i];
        }

        placeHolder = 1;

        // right products
        for (int i = nums.length - 1; i > 0; i--) {
            placeHolder *= nums[i];
            arr[i - 1] *= placeHolder;
        }

        return arr;
    }
}