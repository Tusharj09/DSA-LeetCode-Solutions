import java.util.*;

class Pair {

    int i, j, time;

    public Pair(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
}

class Solution {

    public int bfs(Queue<Pair> q, int[][] grid, int fresh) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dir = {
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1}
        };

        int ans = 0;

        while (!q.isEmpty()) {

            Pair p = q.poll();

            int currI = p.i;
            int currJ = p.j;
            int currTime = p.time;

            ans = Math.max(ans, currTime);

            for (int k = 0; k < 4; k++) {

                int nextI = currI + dir[k][0];
                int nextJ = currJ + dir[k][1];

                if (nextI >= 0 &&
                    nextI < n &&
                    nextJ >= 0 &&
                    nextJ < m &&
                    grid[nextI][nextJ] == 1) {

                    grid[nextI][nextJ] = 2;

                    fresh--;

                    q.offer(new Pair(nextI, nextJ, currTime + 1));
                }
            }
        }

        return fresh == 0 ? ans : -1;
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        return bfs(q, grid, fresh);
    }
}