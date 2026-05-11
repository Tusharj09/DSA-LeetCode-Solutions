class Pair{
    int i,j,dis;
    public Pair(int i , int j ,int dis) {
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
}
class Solution {

    public int[][] bfs(int[][]mat, Queue<Pair> q, int[][]vis,int n, int m){
        int [][]dis = new int[n][m];
        int[][] dir ={{1,0},{0,1},{-1,0},{0,-1} };

        while(!q.isEmpty()) {
                Pair p =  q.poll();
                int currI = p.i;
                int currJ = p.j;
                int currDis = p.dis;
                dis[currI][currJ] = currDis;

                for(int i  = 0 ; i< 4 ; i++) {
                    int nextI= currI + dir[i][0];
                    int nextJ = currJ + dir[i][1];

                    if(nextI >= 0 && nextI<n && nextJ >=0 && nextJ<m && mat[nextI][nextJ] == 1  && 
                        vis[nextI][nextJ]==0 )
                     {
                        vis[nextI][nextJ]= 1; 
                        q.offer(new Pair(nextI,nextJ,currDis +1));   
                     }
                }

        }
        return dis;
    }

    public int[][] updateMatrix(int[][] mat) {

        int n=  mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q =new LinkedList <>();
        
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j< m ; j++){
                if(mat[i][j] == 0) {
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 1;
                }

            }
        }

       return  bfs(mat,q,vis,n,m);
        
    }
}