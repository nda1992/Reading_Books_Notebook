//数组中只出现一次的数字
public class test40 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,5,1,3};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(arr,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
    public static void FindNumsAppearOnce(int[] array,int[] num1,int[] num2){
        if (array==null || array.length<2)
            return;
        int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR^=array[i];        //异或运算,得到的结果是只出现一次的数字的异或结果
        }
        int indexOf1 = 0;
        while (((resultExclusiveOR&1)==0) && (indexOf1<=4*8)){
            resultExclusiveOR=resultExclusiveOR>>1;     //找到二进制中位数为1的位置
            indexOf1++;
        }

        //最终num1和num2表示的就是两个不重复的数字
        num1[0]=0;
        num2[0]=0;
        for (int i = 0; i < array.length; i++) {
            //右移indexOf1位，找到对应位置是否为1,目的是使得相同的数字落到同一个组
            if (((array[i]>>indexOf1)&1)==1)
                num1[0]^=array[i];      //一个数组(一个数组中找出不重复的数字)
            else
                num2[0]^=array[i];      //另外一个数组(一个数组中找出不重复的数字)
        }
    }
}
