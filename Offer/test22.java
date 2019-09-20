import java.util.Stack;

//## 栈的压入、弹出序列
public class test22 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,5,3,1,2};
        System.out.println(IsPopOrder(arr1,arr2));
    }

    public static boolean IsPopOrder(int[] pushSequence,int[] popSequence){

        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex=0,popIndex=0;pushIndex<n;pushIndex++){
            stack.push(pushSequence[pushIndex]);        //将第一个序列入栈
            while (popIndex<n && !stack.isEmpty() && stack.peek()==popSequence[popIndex]){  //判断栈顶元素是否与出栈序列相等
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
