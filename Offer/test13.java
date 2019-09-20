
//O(1)时间删除链表结点
public class test13 {
    public static void main(String[] args) {
        ListNodeUtil head = new ListNodeUtil(1);
        head.setNext(2);
        ListNodeUtil next1 = head.getNext();
        next1.setNext(3);
        ListNodeUtil next2 = next1.getNext();
        next2.setNext(4);
        ListNodeUtil next3 = next2.getNext();
        next3.setNext(5);
        ListNodeUtil next4 = next3.getNext();
        next4=null;
        DeleteListNode(head,3);
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        listNodeUtil.PrintListNode(head);
    }

    public static ListNodeUtil DeleteListNode(ListNodeUtil head,int position){
        if (head==null)
            return null;
        ListNodeUtil list = new ListNodeUtil();
        int size = list.getListNodeLength(head);
        if (position>size||position<1)
            return head;
        if (position==1){
            ListNodeUtil cur = head.next;
            head = null;
            return cur;
        }else {
            ListNodeUtil pre = head;
            int count=1;
            while (count<position){
                pre = pre.next;
                count++;
            }
            ListNodeUtil cur = pre.getNext();
            pre.next=cur.getNext();
            cur=null;
        }
        return head;
    }
}
