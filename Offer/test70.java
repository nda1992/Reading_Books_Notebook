
/*
*
## 最长公共子序列
str1=ace        <br>
str2=babcde     <br>
最长公共子序列为ace，长度为3
* */
//https://blog.csdn.net/weixin_40673608/article/details/84262695
//https://blog.csdn.net/weixin_40673608/article/details/84262695
public class test70 {
    public static void main(String[] args) {
        System.out.println(longSeq("abcde","ace"));
    }

    public static int longSeq(String str1,String str2){

        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];


        for (int i = 0; i <dp[0].length ; i++) {
            for (int j = 0; j <dp[1].length ; j++) {
                dp[i][j]=0;
            }
        }

        for (int i = 1; i <=len1 ; i++) {
            for (int j = 1; j <=len2; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[len1][len2];
    }

}
