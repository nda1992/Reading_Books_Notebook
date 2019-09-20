public class test41 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,11,15};
        System.out.println(FindNumberWithSum(arr,26));
    }

    public static boolean FindNumberWithSum(int[] data,int target){
        boolean found = false;
        if (data.length<1)
            return found;
        int last = data.length-1;
        int behind = 0;

        while (last>behind){
            long sum = data[last]+data[behind];
            if (target==sum){
                found=true;
                break;
            }else if (target<sum)
                last--;
            else
                behind++;
        }
        return found;
    }

}
