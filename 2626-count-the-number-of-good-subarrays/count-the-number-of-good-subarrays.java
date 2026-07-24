import java.util.*;

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        long ans = 0;
        long pairs = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int count = freq.getOrDefault(nums[right], 0);

            pairs += count;
            freq.put(nums[right], count + 1);

            while (pairs >= k) {
                ans += nums.length - right;

                int removeCount = freq.get(nums[left]);

                pairs -= removeCount - 1;

                if (removeCount == 1) {
                    freq.remove(nums[left]);
                } else {
                    freq.put(nums[left], removeCount - 1);
                }

                left++;
            }
        }

        return ans;
    }
}
