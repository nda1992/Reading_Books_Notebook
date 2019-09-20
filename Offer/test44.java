import java.util.Arrays;

//扑克牌的顺子
/*
* 从扑克牌中随机抽取5张牌，判断是不是顺子，大小王可以看成是任意数字
* */
public class test44 {
    public static void main(String[] args) {
        System.out.println(
                isContinuous(new int[]{1,2,0,0,5}));
    }

    public static boolean isContinuous(int[] nums){
        if (nums.length<5)
            return false;
        Arrays.sort(nums);

        //统计数组中0的个数
        int cnt = 0;
        for (int num : nums) {
            if (num==0)
                cnt++;
        }

        for (int i = cnt; i < nums.length-1; i++) {
            if (nums[i+1]==nums[i])
                return false;
            //填充不连续的序列（就是说如果后一个元素跟当前整个元素不连续，就使得cnt-1，填充1个）
            cnt=cnt-(nums[i+1]-nums[i]-1);
        }
        return cnt>=0;
    }


}
