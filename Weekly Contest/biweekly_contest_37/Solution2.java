/**
 * [5528. 网络信号最好的坐标] 
 * 题意：找到一个点使其到其它坐标的距离之和最短，同时每段距离 <= radius
 * 解题思路：暴力枚举
 */

class Solution2 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int max = -1, n = towers.length;
        int[] res = new int[2];

        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                int cur = 0;
                for (int i = 0; i < n; i++) {
                    int dx = towers[i][0], dy = towers[i][1], Q = towers[i][2];
                    int distance = dist(x, y, dx, dy);
                    if (distance > radius * radius) {
                        continue;
                    }
                    cur += (int) Q / (1.0 + Math.sqrt((double)distance));
                }
                if (cur > max) {
                    max = cur;
                    res[0] = x;
                    res[1] = y;
                }
            }
        }
        return res;
    }

    private int dist(int x, int y, int dx, int dy) {
        return (x - dx) * (x - dx) + (y - dy) * (y - dy);
    }
}