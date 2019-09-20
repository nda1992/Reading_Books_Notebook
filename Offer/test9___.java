public class test9___ {
    public static void main(String[] args) {
        System.out.println(Fibonacci(8));
    }

    public static long Fibonacci(int n){
        if (n<2)
            return n;
        long one = 1;
        long two = 0;
        long sum = 0;
        for (int i = 2; i <=n ; i++) {
            sum=one+two;
            two=one;
            one = sum;
        }
        return sum;
    }
}
