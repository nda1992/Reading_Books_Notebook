
////数字在排序数组中出现的次数
public class test38 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,4,5,6};
        System.out.println(GetNumberOfK(arr,2));
    }
    public static int GetNumberOfK(int[] nums,int K){
        int first = BinarySearch(nums, K);          //找到数字k出现的开始位置
        int last = BinarySearch(nums, K+1);     //找到数字k出现的结束位置
        return (first==nums.length||nums[first]!=K)?0:last-first;
    }

    private static int BinarySearch(int[] nums,int k){
        int l=0,h=nums.length;
        while (l<h){
            int mid = l+(h-l)/2;
            if (nums[mid]>=k)
                h=mid;
            else
                l=mid+1;
        }
        return l;
    }


    public static int test(int[] nums,int K){
        if (nums.length==0)
            return 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=K)
                continue;
            size++;
        }
        return size;
    }
}

