class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int bestL = 0;
        int bestR = 0;
        int count = 0;

        while (l < r) {

            if (height[l] <= height[r]) {

                bestL = Math.max(bestL, height[l]);
                count += bestL - height[l];

                l++;

            } else {

                bestR = Math.max(bestR, height[r]);
                count += bestR - height[r];

                r--;
            }
        }

        return count;
    }
}
