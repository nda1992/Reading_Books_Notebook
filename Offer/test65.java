import java.util.ArrayList;
import java.util.PriorityQueue;



//滑动窗口的最大值
public class test65 {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(num,3));
    }

    public static ArrayList<Integer> maxInWindows(int[] num,int size){
        ArrayList<Integer> ret = new ArrayList<>();
        if (size>num.length||size<1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> o2-o1));     //维护一个大堆顶
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        for (int i = 0,j=i+size; j < num.length; i++,j++) {
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
