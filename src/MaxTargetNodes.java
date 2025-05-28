/*
    题目: 3372. 连接两棵树后最大目标节点数目 I
    链接: https://leetcode.cn/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description/
    难度: 中等，bfs+邻接表
    思路: 直接看题解
    时间: 2025/5/28 20:05
*/

import java.util.ArrayList;
import java.util.List;

public class MaxTargetNodes {
    public static void main(String[] args) {
        MaxTargetNodes main = new MaxTargetNodes();
        System.out.println(main);
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int[] count1 = build(edges1, k);
        int[] count2 = build(edges2, k - 1);
        int maxCount2 = 0;
        for (int num : count2) {
            if (num > maxCount2) {
                maxCount2 = num;
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[i] + maxCount2;
        }

        return res;
    }

    private int[] build(int[][] edges, int k) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(i, -1, adj, k);
        }

        return res;
    }

    private int dfs(int node, int parent, List<List<Integer>> adj, int k) {
        if (k < 0) {
            return 0;
        }

        int res = 1;
        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node, adj, k - 1);
        }
        return res;
    }
}
