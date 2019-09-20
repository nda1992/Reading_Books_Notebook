
//反转链表
public class test16 {
    public static void main(String[] args) {
        ListNodeUtil head = new ListNodeUtil(1);
        head.setNext(2);
        ListNodeUtil next1 = head.getNext();
        next1.setNext(3);
        ListNodeUtil next2 = next1.getNext();
        next2.setNext(3);
        ListNodeUtil next3 = next2.getNext();
        next3.setNext(3);
        ListNodeUtil next4 = next3.getNext();
        next4.setNext(4);
        ListNodeUtil next5 = next4.getNext();
        next5.setNext(5);
        ListNodeUtil next6 = next5.getNext();
        next6=null;

//        ListNodeUtil listNodeUtil = ReverseList1(head);
        ListNodeUtil listNodeUtil = test(head);
        Print_ListNode p = new Print_ListNode();
        p.Print_Node(listNodeUtil);
    }

    public static ListNodeUtil ReverseList1(ListNodeUtil head){
        ListNodeUtil pReverse = null;
        ListNodeUtil cur = head;
        ListNodeUtil pre = null;
        while (cur!=null){
            ListNodeUtil temp = cur.next;    //先保存当前结点的下一个结点
            if (temp==null)
                pReverse=cur;
            cur.next = pre; //第一个结点指向null
            pre=cur;
            cur=temp;
        }
        return pReverse;
    }
    //https://www.cnblogs.com/keeya/p/9218352.html
    public static ListNodeUtil test(ListNodeUtil head){
        ListNodeUtil pre = null;
        ListNodeUtil temp = null;
        while (head!=null){
            temp = head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;
    }
}
