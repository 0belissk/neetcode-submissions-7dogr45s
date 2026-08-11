class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] result = new int[n - k + 1];

        // Stores indices
        Deque<Integer> deque = new ArrayDeque<>();

        int resultIndex = 0;

        for (int i = 0; i < n; i++) {

            // 1. Remove index that is outside the window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Maintain decreasing order
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current index
            deque.offerLast(i);

            // 4. Once the first full window is formed,
            // record the maximum
            if (i >= k - 1) {
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
            }
        }

        return result;
    }
}
