/**
 * [5528. 网络信号最好的坐标] 
 * 题意：找到一个点使其到其它坐标的距离之和最短，同时每段距离 <= radius
 */

#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

class Solution {
public:
    int dist(int x, int y, int dx, int dy) {
        return (x - dx) * (x - dx) + (y - dy) * (y - dy);
    }
    vector<int> bestCoordinate(vector<vector<int>>& towers, int R) {
        int a, b, max = -1, n = towers.size();
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                int cur = 0;
                //
                for (int i = 0; i < n; i++) {
                    int dx = towers[i][0], dy = towers[i][1], Q = towers[i][2];
                    int D = dist(x, y, dx, dy);
                    // 找到第一个 Distance < R * R
                    if (D > R * R) continue;
                    cur += (int)((double)Q / (1.0 + sqrt((double)D)));
                }
                if (cur > max) {
                    max = cur;
                    a = x;
                    b = y;
                }
            }
        }
        return {a, b};
    }
};