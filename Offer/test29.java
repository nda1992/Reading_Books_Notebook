
/*
 * 数组{1,2,3,2,2,2,5,4,2}：由于数字2在数组中出现了5次，超过长度的一半，因此输出2.
 * 如果不存在，则输出0
 *
 * */
public class test29 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,3,4};
        System.out.println(MoreThanHalfNum(arr));
    }

    public static int MoreThanHalfNum(int[] nums){
        int majority = nums[0];
        for (int i=1,cnt=1; i < nums.length-1; i++) {
            cnt = nums[i]==majority?cnt+1:cnt-1;
            if (cnt==0){
                majority=nums[i];
                cnt=1;
            }
        }
        int cnt = 0;
        for (int num : nums) {
            if (num==majority)
                cnt++;
        }
        return cnt>nums.length/2?majority:0;
    }

}
