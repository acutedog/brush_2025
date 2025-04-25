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
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int validCount = 0, invalidCount = 0, index = 0;
        for (int num : nums) {
            if (num % modulo == k) {
                validCount++;
                map.put(validCount, index);
                if (k == 0) {
                    result += (invalidCount + 1) * invalidCount / 2;
                    invalidCount = 0;
                }
            } else {
                invalidCount++;
            }
            index++;
        }

        if (k == 0) {
            result += (invalidCount + 1) * invalidCount / 2;
        }

        int count = 1;
        while (count <= validCount) {
            if (count % modulo == k) {
                for (int i = 1; i <= validCount - count + 1; i++) {
                    int leftInvalid = i == 1 ? map.get(i) : map.get(i) - map.get(i - 1) - 1;
                    int rightInvalid = i == validCount - count + 1 ?
                            nums.size() - map.get(validCount) - 1 : (map.get(i + count) - map.get(i + count - 1) - 1);
                    result += (leftInvalid + 1) * (rightInvalid + 1);
                }
            }
            count++;
        }
        return result;
    }
}
