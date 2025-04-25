import java.util.*;

public class CountInterestingSubarrays {
    /*
       题目：2845. 统计趣味子数组的数目
       链接：https://leetcode.cn/problems/count-of-interesting-subarrays/description/?envType=daily-question&envId=2025-04-25
       时间：2025年4月25日19:38:12
       思路：哈希表记录count值的索引；k=0和k!=0要注意区分
    */

    public static void main(String[] args) {
        CountInterestingSubarrays subarrays = new CountInterestingSubarrays();
        System.out.println(subarrays.countInterestingSubarrays(Arrays.asList(3, 2, 4), 2, 1));
        System.out.println(subarrays.countInterestingSubarrays(Arrays.asList(3,1,9,6), 3, 0));
        System.out.println(subarrays.countInterestingSubarrays(Arrays.asList(11,12,21,31), 10, 1));
    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        /*
            (sum[r] − sum[l−1]) % modulo = k 变换为
            (sum[r] − k + modulo) % modulo = sum[l−1] % modulo
         */

        long result = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int prefix = 0;
        cnt.put(0, 1);
        for (int i = 0; i < nums.size(); i++) {
            prefix += nums.get(i) % modulo == k ? 1 : 0;
            result += cnt.getOrDefault((prefix - k + modulo) % modulo, 0);
            cnt.put(prefix % modulo, cnt.getOrDefault(prefix % modulo, 0) + 1);
        }
        return result;
    }
}
