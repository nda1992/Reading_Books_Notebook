
//求1+2+3+...+n
public class test46 {
    public static void main(String[] args) {
        System.out.println(Sum(100));
    }


    public static int Sum(int n){
        int sum = n;
        boolean b = (n>0)&&((sum+=Sum(n-1))>0);
        return sum;
    }
}
