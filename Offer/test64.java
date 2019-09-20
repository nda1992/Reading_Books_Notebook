import java.util.PriorityQueue;

//数据流中的中位数
public class test64 {
    public static void main(String[] args) {
        Insert(1);
        Insert(2);
        Insert(3);
        Insert(4);
//        Insert(5);
        Double aDouble = GetMedian();
        System.out.println(aDouble);
    }
    //大堆顶
    private static PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->o2-o1);
    //小堆顶
    private static PriorityQueue<Integer> right = new PriorityQueue<>();

    private static int N = 0;   //数据流读入的数据个数
    public static void Insert(Integer val){
        //要保证两个堆处于平衡状态
        if (N%2==0){
            /*
            * N为偶数时，插入到右半边
            * 因为右半边元素要大于左半边，但是新插入的元素不一定比左半边的元素大，
            * 所以需要先将元素插入到左半边，然后利用左半边大堆顶的特点，取出堆顶元素即为最大元素，此时插入右半边
            * */
            left.add(val);
            right.add(left.poll());
        }else {
            //反之插入到左半边
            right.add(val);
            left.add(right.poll());         //poll()表示返回队列的头部元素，并移除
        }
        N++;
    }
    public static Double GetMedian(){
        if (N%2==0){
            return (left.peek()+right.peek())/2.0;      //返回左边最大和右边最小
        }else {
            return (double)right.peek();    //peek()表示返回队列的头部元素
        }
    }
}
