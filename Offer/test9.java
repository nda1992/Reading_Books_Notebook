

//一只青蛙可以跳上1级台阶，也可以跳上2级台阶，求跳上一个n级台阶共有多少种跳法
//f(n)=f(n-1)+f(n-2)
public class test9 {
    public static void main(String[] args) {

        System.out.println(JumpFloor(5));
    }

    public static int JumpFloor(int n){
        if (n<=2)
            return n;
        int pre2 = 1,pre1 = 2;
        int result = 1;
        for (int i = 2; i < n; i++) {
            result=pre1+pre2;
            pre2=pre1;
            pre1=result;
        }
        return result;
    }

}
