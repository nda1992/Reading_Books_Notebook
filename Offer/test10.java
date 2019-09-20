
//二进制中1的个数
public class test10 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(-7));
        System.out.println(test(-7));
    }
    //方法1
    public static int NumberOf1(int n){
        int cnt = 0;
        while (n!=0)
        {
            cnt++;
            n&=(n-1);
        }
        return cnt;
    }

    //方法2
    public static int test(int n){
        int count = 0;
        int flag = 1;
        while (flag!=0){
            if ((n&flag)!=0)
                count++;
            flag<<=1;
        }
        return count;
    }

}
