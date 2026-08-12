class Solution {

    class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        Deque<Pair> deque = new ArrayDeque<>();

        int resIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            // 1. Remove element if it is outside the window
            if (!deque.isEmpty() && deque.peekFirst().index <= i - k) {
                deque.pollFirst();
            }

            // 2. Maintain decreasing order
            while (!deque.isEmpty() &&
                   deque.peekLast().value < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current value + index
            deque.addLast(new Pair(nums[i], i));

            // 4. Once we have a full window, record the max
            if (i >= k - 1) {
                result[resIndex] = deque.peekFirst().value;
                resIndex++;
            }
        }

        return result;
    }
}