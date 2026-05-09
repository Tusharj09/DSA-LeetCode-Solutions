class Solution {
public void dfs(int node , int[][] isConnected, boolean[] vis ) {

    vis[node] = true;
    for(int i = 0 ; i <isConnected[node].length ; i++) {

        if(!vis[i] && isConnected[node][i]!=0 && i != node){
            vis[i] = true;
            dfs(i,isConnected, vis);
        }

    }
}

    public int findCircleNum(int[][] isConnected) {
        int nprovinces = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        for(int i = 0 ; i< n; i++) {

            if(!vis[i]) {
                nprovinces++;
                dfs(i,isConnected,vis);
            }

        }
        return nprovinces;
        
    }
}