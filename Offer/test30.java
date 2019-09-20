import java.util.TreeSet;

//## 最小的K个数
//输入n个连续的整数，找出其中最小的k个数，如4,5,1,6,2,7,3,8中，最小的4个数字为1,2,3,4
public class test30 {
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        TreeSet<Integer> set = new TreeSet<>();
        GetLastNumbers(arr,set,4);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    public static void GetLastNumbers(int[] nums,TreeSet<Integer> targets,int k){
        if (k<1||nums.length<k)
            return;
        //遍历nums，与容器中的最大值比较
        for (int i = 0; i < nums.length; i++) {
            if (targets.size()<k)
                targets.add(nums[i]);
            else {
                Integer last = targets.last();
                if (nums[i]<targets.last()){
                    targets.remove(last);
                    targets.add(nums[i]);
                }
            }
        }
    }
}
