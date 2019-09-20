//从头到尾打印链表

import java.util.ArrayList;
import java.util.Stack;

public class test5 {
    public static void main(String[] args) {
        ListNodeUtil head = new ListNodeUtil(1);
        head.setNext(2);
        ListNodeUtil next1 = head.getNext();
        next1.setNext(3);
        ListNodeUtil next2 = next1.getNext();
        next2.setNext(4);
        ListNodeUtil next4 = next2.getNext();
        next4=null;

        ArrayList<Integer> arrayList = printListFromToHead(head);
//        System.out.println(arrayList);

        test(head);
    }
    //使用栈
    public static ArrayList<Integer> printListFromToHead(ListNodeUtil listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()){
            ret.add(stack.pop());
        }
        return ret;
    }


    //递归方法
    public static void test(ListNodeUtil head){
        if (head!=null){
            if (head.next!=null){
                test(head.next);
            }
            System.out.println(head.val+" ");
        }
    }
}
