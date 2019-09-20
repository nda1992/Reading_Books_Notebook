import java.util.ArrayList;

//数组中的逆数对
public class test36 {
    public static void main(String[] args) {
        int[] arr = {7,5,6,4};
        ArrayList<ArrayList<Integer>> test = test(arr);
        for (ArrayList<Integer> arrayList : test) {
            System.out.println(arrayList);
        }
    }

    public static int InversePairs(int[] array){
        if (array==null || array.length<=0)
            return 0;
        int count = getCount(array,0,array.length-1);
        return count%1000000007;
    }

    public static int getCount(int[] array,int start,int end){
        if (start>=end)
            return 0;
        int mid=(start+end)>>1;
        int left = getCount(array,start,mid);
        int right = getCount(array,mid+1,end);

        int count = 0;

        int i = mid;
        int j = end;
        int[] temp = new int[end-start+1];
        int k = end-start;
        while (i>=start && j>=mid+1){
            if (array[i]>array[j]){
                count+=(j-mid);
                temp[k--]=array[i--];
            }else{
                temp[k--]=array[j--];
            }
        }

        while(i>=start)
            temp[k--]=array[i--];
        while (j>=mid+1)
            temp[k--]=array[j--];
        for (k = 0; k < temp.length; k++) {
            array[k+start]=temp[k];
        }
        return count+left+right;
    }


    //O(n^2)
    public static ArrayList<ArrayList<Integer>> test(int[] nums){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    list.add(temp);
                }
            }
        }
        return list;
    }
}
