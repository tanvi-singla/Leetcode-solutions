class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length-1;
        int col=obstacleGrid[0].length-1;
        int[][] dp=new int[row+1][col+1];
        for(int i=0;i<=row;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(row,col,obstacleGrid,dp);
    }
    public int solve(int row,int col,int[][] arr,int[][] dp){
        if(row>=0 && col>=0 && arr[row][col]==1 ) return 0;
        if(row==0 && col==0) return 1;
        if(row<0 || col<0) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        int up=solve(row-1,col,arr,dp);
        int left=solve(row,col-1,arr,dp);
        return dp[row][col]=up+left;
    }
}