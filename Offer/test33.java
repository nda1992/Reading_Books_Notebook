import java.util.Arrays;
//把数组排列成最小的数
public class test33 {
    public static void main(String[] args) {
        int[] nums = {3,32,321};
        System.out.println(PrintMinNumber(nums));
    }
    public static int PrintMinNumber(int[] numbers){
        if (numbers==null || numbers.length==0)
            return 0;
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i <n ; i++) {
            nums[i]=numbers[i]+"";
        }
        /*
        * 将nums中的两两字符串拼接（如n、m-->nm和mn，比较两个字符串表示数值的大小）
        * */
        Arrays.sort(nums,(s1, s2)->(s1+s2).compareTo(s2+s1));   //使用compareTo进行排序的重新定义
        String ret = "";
        for (String str : nums) {
            ret+=str;
        }
        return Integer.parseInt(ret);
    }

}
