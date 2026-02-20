class Solution {

    public int profitGenerated(int n, int[] prices, int buy, int[][] dp) {

        if (n == prices.length)
            return 0;

        if (dp[n][buy] != -1)
            return dp[n][buy];
        int take = 0;

        if (buy == 0) {
            take = -prices[n] + profitGenerated(n + 1, prices, 1, dp);
        } else
            take = prices[n] + profitGenerated(n + 1, prices, 0, dp);

        int notTake = 0 + profitGenerated(n + 1, prices, buy, dp);

        return dp[n][buy] = Math.max(take, notTake);

    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int dp[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return profitGenerated(0, prices, 0, dp);

    }
}