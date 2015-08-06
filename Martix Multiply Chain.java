import java.util.*;
import java.io.*;
public class Solution {
    int getMinMultiCost(int[] q){
        int len = q.length-1;
        int[][] dp =new int[len][len];
        for(int i=0;i<len;i++) dp[i][i]=0;
        for(int i=1;i<len;i++){//i is sublen
            //compute[0..i],[1..i+1],[2..i+2]..[len-i-1..len-1]
            for(int begin=0;begin<len-i;begin++){
                int end = begin+i;
                //dp[begin][end] = min{dp[begin][k]+dp[k][end]+q[begin]*q[k]*q[end]}(begin <= k < end)
                int tmp = Integer.MAX_VALUE;
                for(int k=begin;k<end;k++){
                    int cur = dp[begin][k]+dp[k+1][end]+q[begin]*q[k+1]*q[end+1];
                    if(cur<tmp){
                        tmp = cur;
                    }
                }
                dp[begin][end] = tmp;
            }
        }
        for(int i=0;i<len;i++) {
            for (int j = 0; j < len; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        return dp[0][len-1];
    }
    public static void main(String[] argv){
        int [] q = {1,2,3,5,4,8};//matrix is: q[1]*q[2],q[2]*q[3],q[3]*q[4],...,q[len-1][len]
        Solution solution = new Solution();
        int ans = solution.getMinMultiCost(q);
        System.out.println(ans);
    }
}

