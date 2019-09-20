
//##打印1到最大的n位数
//输入3位数，打印出1,2,3...999
public class test12 {
    public static void main(String[] args) {
        printToMaxOfDigits(3);
    }
    public static void printToMaxOfDigits(int n){
        if (n<=0)
            return;
        char[] numbers = new char[n+1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]='0';
        }
        while (!incrementNumber(numbers)){
            printNumber(numbers);
        }

    }

    public static boolean  incrementNumber(char[] numbers){
        boolean isOverFflow = false;

        int nTakeOver = 0;
        int len = numbers.length;
        for (int i = len-1; i >=0 ; i--) {
            int Sum = numbers[i]-'0'+nTakeOver;
            if (i==len-1)
                ++Sum;
            if (Sum>=10){
                if (i==0)
                    isOverFflow=true;
                else {
                    Sum-=10;
                    nTakeOver=1;
                    numbers[i]=(char)('0'+Sum);
                }
            }else {
                numbers[i]=(char)(Sum+'0');
                break;
            }
        }
        return isOverFflow;
    }

    public static void printNumber(char[] numbers){
        boolean isBeginning = true;
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            if (isBeginning&&numbers[i]!='0')
                isBeginning=false;
            if (!isBeginning){
                System.out.println(numbers[i]);
            }
        }
    }
}
