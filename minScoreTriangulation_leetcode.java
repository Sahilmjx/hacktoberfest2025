class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        
        int[][] memo = new int[n+1][n+1];
        for(int[] arr : memo){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        return helper(values, 0, n, memo);
    }

    public int helper(int[] values, int start, int end, int[][] memo){
        int d = end-start;
        if(d == 3){
            return values[start]*values[start+1]*values[start+2];
        }
        if(d < 3){
            return 0;
        }

        if(memo[start][end] != Integer.MAX_VALUE){
            return memo[start][end];
        }

        for(int i = start+1; i<end-1; i++){
            int curr = helper(values, start, i+1, memo) + helper(values, i, end, memo) + values[start]*values[end-1]*values[i];
            memo[start][end] = Math.min(memo[start][end], curr);
        }

        return memo[start][end];
    }
}
