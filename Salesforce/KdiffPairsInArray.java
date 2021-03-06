// use two pointers
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0, end = 0;
        int count = 0;
        while (start < nums.length && end < nums.length) {
            if (start == end || nums[end] - nums[start] < k) {
                end++;
            } else if (nums[end] - nums[start] > k) {
                start++;
            } else {
                start++;
                count++;
                while (start < nums.length && nums[start] == nums[start - 1]) {
                    start++;
                }
                end = Math.max(start + 1, end + 1);
            }
        }
        return count;
    }
}

class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }

        Arrays.sort(nums);
        int start = 0, end = 1;
        int count = 0;
        while (start < end && end < nums.length) {
            if (nums[end] - nums[start] < k) {
                end++;
            } else {
                if (nums[end] - nums[start] == k) {
                    if (start == 0 || nums[start] != nums[start - 1]) {
                        count++;
                    }
                }
                start++;
                if (start == end) {
                    end++;
                }
            }
        }
        return count;
    }
}

// use hashmap
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
