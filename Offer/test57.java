
//删除链表的重复结点
public class test57 {
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

        Print_ListNode print_listNode = new Print_ListNode();
        print_listNode.Print_Node(deleteDuplication1(head));
    }
    //递归算法
    public static ListNodeUtil deleteDuplication(ListNodeUtil head){
        if (head==null || head.next==null)
            return head;
        ListNodeUtil next = head.next;
        if (head.val==next.val){
            while (next!=null && head.val==next.val)
                next=next.next;
            return deleteDuplication(next);
        }else {
            head.next = deleteDuplication(head.next);
            return head;
        }
    }

    //非递归算法
    public static ListNodeUtil deleteDuplication1(ListNodeUtil head){
        ListNodeUtil first = new ListNodeUtil(-1);
        first.next=head;
        ListNodeUtil last = first;  //初始化链表,last总是在p的后面一个位置
        ListNodeUtil p = head;  //头结点
        while (p!=null &&p.next!=null){
            if (p.val==p.next.val){
                int val = p.val;
                /*
                * 如果出现重复，则跳过所有的重复结点，使用last保存重复结点的前一个结点，
                * 等到出现不重复为止，将last与不重复的结点连接起来即可
                * */
                while (p!=null && p.val==val) {
                    p=p.next;
                    last.next=p;
                }
            }else {
                last = p;
                p=p.next;
            }
        }
        return first.next;
    }

}
