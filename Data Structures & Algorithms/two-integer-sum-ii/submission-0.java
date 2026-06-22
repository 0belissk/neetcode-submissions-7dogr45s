class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length - 1;
        boolean found = false;
        int[] sum = new int[2];

        while (a <= b && found == false) {
            if (numbers[a] + numbers[b] == target) {
                sum[0] = a + 1;
                sum[1] = b + 1;
                found = true;
            }
            else if(numbers[a] + numbers[b] > target) {
                b -= 1;
            }
            else if(numbers[a] + numbers[b] < target) {
                a += 1;
            }
        }

        return sum;
    }
}
