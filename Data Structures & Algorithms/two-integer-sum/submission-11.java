class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        int i = 0;
        boolean found = false;
        while (i < nums.length && found == false) {

            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                arr[0] = Math.min(i, map.get(target - nums[i]));
                arr[1] = Math.max(map.get(target - nums[i]), i);
                found = true;
            }
            i++;
        }

        return arr;
    }
}
