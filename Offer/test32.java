//从1到n整数中出现以的次数
public class test32 {
    public static void main(String[] args) {
        System.out.println(NumberOfBetween1AndN(11));
    }

    public static int NumberOfBetween1AndN(int n){
        if (n<0)
            return -1;
        int number = 0;
        for (int i = 1; i <= n; i++) {
            number+=NumberOf1(i);
        }
        return number;
    }

    public static int NumberOf1(int n){
        int number=0;
        while (n>0){
            if (n%10==1)
                number++;
            n/=10;
        }
        return number;
    }




}
