import java.util.Stack;

//包含min函数的栈
/*
* 定义一个数据结构：在该类型中实现一个能够的都栈的最小元素的min函数，在该栈中，调用min函数、
push和pop的时间复杂度为O(1)
* */
public class test21 {
    public static void main(String[] args) {
        test21 test = new test21();
        test.push(3);
        test.push(4);
        test.push(2);
        test.push(1);
        test.pop();
        test.pop();
        test.pop();
//        System.out.println(test.top());
        System.out.println(test.getMin());
        System.out.println(test.top());
    }

    private Stack<Integer> stack=new Stack<>();
    private Stack<Integer> stack_helper=new Stack<>();


    public void push(int x){
        stack.push(x);
        if (stack_helper.isEmpty() || x<=stack_helper.peek())
            stack_helper.push(x);
    }

    public void pop(){
        //如果是出栈操作，stack出栈并删除栈顶元素，stack_helper不删除栈顶元素
        if (stack.pop().equals(stack_helper.peek()))
            stack_helper.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return stack_helper.peek();
    }
}
