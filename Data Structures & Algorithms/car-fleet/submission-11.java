class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));
        Deque<Double> stack = new ArrayDeque<>();


        for (int i = n - 1; i >= 0; i--) {
            double time =
                (double) (target - cars[i][0]) / cars[i][1];

            // If this car takes longer than the fleet ahead,
            // it cannot catch it, so it becomes a new fleet.
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }

            // Otherwise, time <= stack.peek()
            // so this car catches the fleet ahead.
        }

        return stack.size();
    }
}