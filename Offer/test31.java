//连续子数组最大和
public class test31 {
    public static void main(String[] args) {
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        int[] arr1 = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumSubArray(arr));
        System.out.println(test(arr));
    }

    public static int FindGreatestSumSubArray(int[] nums){
        if (nums==null||nums.length==0)
            return 0;
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum<=0?val:sum+val;
            greatestSum=Math.max(greatestSum,sum);
        }
        return greatestSum;
    }

    //方法2:（复杂度为O(n)）
    public static int test(int[] nums){
       if (nums==null&&nums.length<=0)
           return 0;
       int cursum  = 0;
       int greatsum = 0x80000000;
        for (int i = 0; i < nums.length-1; i++) {
            //当前的和小于零，那么再加上下一个数字后，比没加上该数字的和还要小，所以用当前值替换之前的子数组的累加和
            if (cursum<=0)
                cursum=nums[i];
            else
                cursum+=nums[i];
            //如果当前子数组的和大于之前连续子数组的和，则使用当前和替换掉之前的累加和
            if (cursum>greatsum)
                greatsum=cursum;
        }
        return greatsum;
    }
}
