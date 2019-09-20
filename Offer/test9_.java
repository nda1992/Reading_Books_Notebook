import java.util.Arrays;

//变态跳台阶
/*
* 一次可以跳上1级台阶，也可以跳上2级台阶，也可以跳上n级台阶，求n级台阶有几种跳法
* f(n)=f(n-1)+f(n-2)+...+f(2)+f(1)
* */
public class test9_ {
    public static void main(String[] args) {

        System.out.println(JumpFloor(6));
    }

    public static int JumpFloor(int target){
        int[] dp = new int[target];
        Arrays.fill(dp,1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target-1];
    }
}
