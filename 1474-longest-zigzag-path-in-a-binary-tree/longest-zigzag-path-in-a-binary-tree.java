/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



class Solution {
    int maxi= 0;

    public void dfs(TreeNode node ,  boolean goleft, int steps ) {

        if(node == null) return ;

        maxi = Math.max(maxi,steps);

        if(goleft) {
            dfs(node.left,false,steps+1);
            dfs(node.right,true, 1);
        }
        else {
             dfs(node.left,false,1);
            dfs(node.right,true, steps+1);
        }

    }



    public int longestZigZag(TreeNode root) {

  


        dfs(root,true,0);


        return maxi;
    }
}