package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PartitionKSubsets {
    boolean[] dp; // 记录S状态下是否可行
    int[] nums;
    int perSum;
    int numLength;

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(Arrays.toString(a));
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        this.perSum = sum / k;
        nums = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        this.numLength = nums.length;
        if (nums[numLength - 1] > perSum) return false;
        this.dp = new boolean[1 << nums.length];
        this.nums = nums;
        Arrays.fill(dp, true);
        return dfs(1<< numLength, 0);
    }

    public boolean dfs(int t, int s) {
        if (t==0)return true;
//        if(!dp[t])
        return false;
    }

}
