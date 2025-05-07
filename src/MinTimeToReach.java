import java.util.Arrays;
import java.util.PriorityQueue;

public class MinTimeToReach {
    /*
        题目: 3341. 到达最后一个房间的最少时间 I
        链接: https://leetcode.cn/problems/find-minimum-time-to-reach-last-room-i/description/?envType=daily-question&envId=2025-05-07
        难度: 中等
        思路: Dijkstra 算法
        时间: 2025年5月7日19:38:59
    */

    public static void main(String[] args) {
        MinTimeToReach main = new MinTimeToReach();
        System.out.println(main.minTimeToReach(new int[][] {{0,4}, {4,4}}));
        System.out.println(main.minTimeToReach(new int[][] {{0,0,0}, {0,0,0}}));
    }

    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] minDistances = new int[n][m];
        for (int[] minDistance : minDistances) {
            Arrays.fill(minDistance, Integer.MAX_VALUE);
        }
        minDistances[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[]{0, 0, 0});
        while (true) {
            int[] minDistance = pq.poll();
            int distance = minDistance[0], i = minDistance[1], j = minDistance[2];
            if (i == n - 1 && j == m - 1) {
                return distance;
            }

            if (distance > minDistances[i][j]) {
                continue;
            }

            for (int[] direction : DIRS) {
                int x = i + direction[0], y = j + direction[1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int newDistance = Math.max(moveTime[x][y], distance) + 1;
                    if (newDistance < minDistances[x][y]) {
                        minDistances[x][y] = newDistance;
                        pq.add(new int[]{newDistance, x, y});
                    }
                }
            }
        }
    }
}
