import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinTimeToReachSecond {
    /*
        题目: 3342. 到达最后一个房间的最少时间 II
        链接: https://leetcode.cn/problems/find-minimum-time-to-reach-last-room-ii/description/?envType=daily-question&envId=2025-05-08
        难度: 中等
        思路: 同1，昨天看题解，今天自己写，巩固之
        时间: 2025年5月8日21:32:38
    */

    public static void main(String[] args) {
        MinTimeToReachSecond main = new MinTimeToReachSecond();
        System.out.println(main.minTimeToReach(new int[][] {{0,4}, {4,4}}));
        System.out.println(main.minTimeToReach(new int[][] {{0,0,0,0}, {0,0,0,0}}));
    }

    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] dp = new int[m][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        while (true) {
            int[] curr = pq.poll();
            int distance = curr[0], i = curr[1], j = curr[2];

            if (i == m -1 && j == n - 1) {
                return distance;
            }

            if (distance > dp[i][j]) {
                continue;
            }

            for (int[] direction : DIRS) {
                int x = i + direction[0], y = j + direction[1];
                int time = (x + y) % 2 == 0 ? 2 : 1;
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int newDistance = Math.max(distance, moveTime[x][y]) + time;
                    if (newDistance < dp[x][y]) {
                        dp[x][y] = newDistance;
                        pq.offer(new int[]{newDistance, x, y});
                    }
                }
            }
        }
    }
}
