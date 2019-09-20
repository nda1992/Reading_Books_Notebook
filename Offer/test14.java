
//调整数组顺序使奇数位于偶数前面

import java.util.Arrays;

public class test14 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
//        reOrderArray(arr);
//        System.out.println(Arrays.toString(arr));

        test(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reOrderArray(int[] nums){
        int oddCnt = 0;
        for (int val : nums) {
            if (val%2==1)
                oddCnt++;
        }
        int[] copy = nums.clone();
        int i=0,j=oddCnt;
        for (int num : copy) {
            if (num%2==1)
                nums[i++]=num;
            else
                nums[j++]=num;
        }
    }

    //方法2
    public static void test(int[] nums){
        if (nums==null)
            return;
        int i=0;
        int j=nums.length-1;
        while (i<j){
            while (i<j&&nums[i]%2!=0) i++;
            while (i<j&&nums[j]%2==0) j--;
            if (i<j){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
            i++;
            j--;
        }
    }
}
