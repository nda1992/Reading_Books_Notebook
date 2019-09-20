import java.util.ArrayList;

/*
* ## 和为S的连续正数序列
输入有一个正数S，打印出所有和为S的连续正数序列（至少包含两个数），
如15,1+2+3+4+5=4+5+6=7+8=15，所以输出3个连续序列1~5,4~6,7~8
* */
public class test41_ {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(15);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList);
        }
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start=1,end=2;
        int curSum = 3;
        while (end>start){
            if (curSum>sum){        //如果cursum>sum，表示要缩小范围，start+1
                curSum-=start;      //同时要减去对应的值
                start++;            //然后start+1
            }else if (curSum<sum){  //如果cursum<sum，表示要增大范围，end+1
                end++;              //先end+1
                curSum+=end;        //然后加上对应的值
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);
                curSum-=start;
                start++;
                end++;
                curSum+=end;
            }
        }
        return ret;
    }
}
