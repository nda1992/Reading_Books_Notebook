
//## 数值的整数次方
public class test11 {
    public static void main(String[] args) {
        System.out.println(test(5,0));
    }


    public static double Power(int base,int exp){
        if (exp==0)
            return 1;
        if (exp==1)
            return base;
        boolean isNegative = false;
        if (exp<0)
        {
            exp=-exp;
            isNegative=true;
        }
        double pow = Power(base*base,exp/2);
        if (exp%2!=0)
            pow=pow*base;
        return isNegative?1/pow:pow;
    }


    //方法2
    public static double test(double num,int e){
        if (e==0)
            return 1;
        if (e==1)
            return num;
        if (equal(num,0.0)&&e<0)
            return 0.0;

        boolean neg = false;
        double result = 1.0;
        if (e<0) {
            e=-e;
            neg=true;
        }
        while (e>0){
            result*=num;
            e--;
        }
        return neg?1.0/result:result;
    }

    public static boolean equal(double num1,double num2){
        if ((num1-num2>-0.0000001) &&(num1-num2<0.0000001))
            return true;
        else
            return false;
    }
}
