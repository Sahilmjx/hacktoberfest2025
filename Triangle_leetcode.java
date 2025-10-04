class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()+1][triangle.size()+1];

        for(int[] arr : memo){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        return helper(triangle, 0, 0, triangle.size(), memo);
    }

    public int helper(List<List<Integer>> list, int r, int c, int n, int[][] memo){
        if(r == n){
            return 0;
        }
        if(memo[r][c] != Integer.MAX_VALUE){
            return memo[r][c];
        }
        return memo[r][c] = Math.min(list.get(r).get(c) + helper(list, r+1, c, n, memo), list.get(r).get(c) + helper(list, r+1, c+1, n, memo));
    }
}
