
//## 数组中重复的数字
/*
数组长度为n的数组里，所有数字都在0～n-1范围内.数组中的某些数字重复了，
但是不知道有几个数字重复了，也不知道每个数字重复的次数，找出数组中任
意一个重复的数字
*/

import java.util.HashSet;
import java.util.Set;

public class test51 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        System.out.println(test(arr));
    }

    public static boolean duplicate(int[] nums,int length,int[] duplication){

        if (nums==null ||length<=0)
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i]!=i){
                if (nums[i]==nums[nums[i]]){
                    duplication[0]=nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);
            }
        }

        return false;
    }

    public static void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public static int test(int[] nums){
        Set<Integer> set = new HashSet<>();
        int target=-1;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                target=nums[i];
                break;
            }else {
                set.add(nums[i]);
            }
        }
        return target;
    }
}
