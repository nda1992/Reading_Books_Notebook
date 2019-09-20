import java.util.ArrayList;

/*
* ## 丑数
只包含因子2,3,5,的数称为丑数
根据索引求出第index个丑数
* */
public class test34 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = GetUglyNumber(1500);
        System.out.println(arrayList);
    }

    public static ArrayList<Integer> GetUglyNumber(int index){
        if (index<=0)
            return null;
        int number = 0;
        int uglyFound = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (uglyFound<index){
            ++number;
            if (IsUgly(number)){
                ++uglyFound;
                arr.add(number);
            }
        }
        return arr;
    }

    public static boolean IsUgly(int number){
        while (number%2==0)
            number/=2;
        while (number%3==0)
            number/=3;
        while (number%5==0)
            number/=5;

        if (number==1)
            return true;
        else
            return false;
    }
}
