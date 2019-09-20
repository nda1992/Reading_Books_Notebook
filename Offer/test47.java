
//不用加减乘除的加法
public class test47 {
    public static void main(String[] args) {

        System.out.println(Add(11,6));
    }

    public static int Add(int num1,int num2){
        int sum,carry;
        do {
            sum = num1^num2;
            carry = (num1&num2)<<1;
            num1 = sum;
            num2 = carry;
        }while (num2!=0);

        return num1;
    }

}
