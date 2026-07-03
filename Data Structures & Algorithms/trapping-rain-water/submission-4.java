class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = height.length - 1;
        int totalWater = 0;

        while (l <= r) {
            
            
            if (leftMax <= rightMax) {
                leftMax = Math.max(height[l], leftMax);
                int difference = leftMax - height[l];
                totalWater += difference;
                l += 1;
            } else {
                rightMax = Math.max(height[r], rightMax);
                int difference = rightMax - height[r];
                totalWater += difference;
                r -= 1;
            }
        }

        return totalWater;
    }
}
