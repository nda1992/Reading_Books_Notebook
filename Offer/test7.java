import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//用两个栈实现队列
public class test7 {
    public static void main(String[] args) {
//        push(5);
//        push(4);
//        push(3);
//        push(2);
//        push(1);
//        System.out.println(pop());
//        System.out.println(pop());
//        push(6);
//        System.out.println(pop());
//        push(7);
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());

        push1(1);
        push1(2);
        push1(3);
        push1(4);
        push1(5);
        System.out.println(pop1());
        System.out.println(pop1());
        System.out.println(pop1());
        System.out.println(pop1());
        System.out.println(pop1());
        System.out.println(pop1());

    }

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    //入队
    public static void push(int num){
        stack1.push(num);
    }
    //出队
    public static int pop(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty())
            return stack2.pop();
        else
            return -1;
    }


    //两个队列实现栈
    private static Queue<Integer> queue1 = new LinkedList<>();
    private static Queue<Integer> queue2 = new LinkedList<>();

    public static void push1(int data){
        if (queue1.isEmpty())
            queue2.add(data);
        else
            queue1.add(data);
    }

    public static int pop1(){
        int i,size;
        if (queue2.isEmpty()){
            size = queue1.size();
            i=0;
            while (i<size-1){
                queue2.add(queue1.poll());
                i++;
            }
                return queue1.poll();

        }else {
            size=queue2.size();
            i=0;
            while (i<size-1){
                queue1.add(queue2.poll());
                i++;
            }
                return queue2.poll();
        }
    }

}
