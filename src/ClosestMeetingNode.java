/*
    题目: 2359. 找到离给定两个节点最近的节点
    链接: https://leetcode.cn/problems/find-closest-node-to-given-two-nodes/description/?envType=daily-question&envId=2025-05-30
    难度: 中等
    思路: 遍历
    时间: 2025/5/30 22:03
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClosestMeetingNode {
    public static void main(String[] args) {
        ClosestMeetingNode main = new ClosestMeetingNode();
        System.out.println(main.closestMeetingNode(new int[] {2,2,3,-1}, 0, 1));
        System.out.println(main.closestMeetingNode(new int[] {1,2,-1}, 0, 2));
        System.out.println(main.closestMeetingNode(new int[] {9,8,7,0,5,6,1,3,2,2}, 1, 6));
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] arrives1 = getArrives(edges, node1);
        int[] arrives2 = getArrives(edges, node2);
        int closest = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        for (int i = 0; i < arrives1.length; i++) {
            if (arrives1[i] != -1 && arrives2[i] != -1) {
                int distance = Math.max(arrives2[i], arrives1[i]);
                if (distance < closest) {
                    closest = distance;
                    result = i;
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int[] getArrives(int[] edges, int node1) {
        int[] arrives = new int[edges.length];
        Set<Integer> visited = new HashSet<>();
        Arrays.fill(arrives, -1);
        arrives[node1] = 0;
        visited.add(node1);
        int index = node1, distance = 1;
        while (edges[index] != -1 && !visited.contains(edges[index])) {
            arrives[edges[index]] = distance;
            index = edges[index];
            distance++;
            visited.add(index);
        }
        return arrives;
    }
}
