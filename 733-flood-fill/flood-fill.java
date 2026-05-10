class Pair {
    int i , j; 
    public Pair(int i , int j ) {
        this.i = i;
        this.j = j;
;    }
}

class Solution {


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int oldColor = image[sr][sc];

         if (oldColor == newColor) {
            return image;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc));
        image[sr][sc]= newColor;
        int [][] dir = {{ 0,1} , {1,0}, {-1,0},{0,-1}};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int currI = p.i;
            int currJ = p.j;

            for(int i = 0 ; i< 4 ; i++) {
                int nextI = currI + dir[i][0];
                int nextJ = currJ + dir[i][1];

                if( nextI >=0 && nextI <image.length && nextJ >=0 && nextJ<image[0].length && 
                    image[nextI][nextJ] == oldColor
                )   {
                    image[nextI][nextJ]= newColor;
                    q.offer(new Pair(nextI ,nextJ));
                }
            }
        }

        return image;
    }
}
