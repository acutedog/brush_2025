public class TriangleType {
    /*
        题目: 3024. 三角形类型
        链接: https://leetcode.cn/problems/type-of-triangle/description/?envType=daily-question&envId=2025-05-19
        难度: 简单
        思路:
        时间: 2025年5月19日22:11:43
    */

    public static void main(String[] args) {
        TriangleType main = new TriangleType();
        System.out.println(main.triangleType(new int[] {2, 2, 2}));
        System.out.println(main.triangleType(new int[] {2, 2, 3}));
        System.out.println(main.triangleType(new int[] {2, 2, 5}));
    }

    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] < nums[2] || nums[1] + nums[2] < nums[0] || nums[2] + nums[0] < nums[1]) {
            return "none";
        }

        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }

        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0]) {
            return "isosceles";

        }

        return "scalene";
    }
}
