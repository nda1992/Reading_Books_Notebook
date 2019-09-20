//两个链表的第一个公共结点
public class test37 {
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
        next4.next=null;


        ListNodeUtil head_ = new ListNodeUtil(2);
        head_.setNext(3);
        ListNodeUtil next1_ = head_.getNext();
        next1_.setNext(4);
        ListNodeUtil next2_ = next1_.getNext();
        next2_.setNext(5);
        ListNodeUtil next3_ = next2_.getNext();
//        next3_.setNext(5);
//        ListNodeUtil next4_ = next3_.getNext();
        next3.next=null;

        System.out.println(FindFirstCommonNode(head,head_).val);
    }

    public static ListNodeUtil FindFirstCommonNode(ListNodeUtil pHead1,ListNodeUtil pHead2){
        if (pHead1==null || pHead2==null)
            return null;

        int len1 = GetLengthList(pHead1);
        int len2 = GetLengthList(pHead2);
        ListNodeUtil temp1 =pHead1;
        ListNodeUtil temp2 =pHead2;

        if (len1>len2){
            while (len1>len2){
                temp1 = temp1.next;
                len1--;
            }
        }else if (len2>len1){
            while (len2>len1){
                temp2=temp2.next;
                len2--;
            }
        }
        while (temp1.val!=temp2.val){
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return temp1;
    }

    public static int GetLengthList(ListNodeUtil head){ //求链表长度
        if (head==null)
            return 0;
        int size = 0;
        ListNodeUtil cur = head;

        while (cur!=null){
            size++;
            cur=cur.next;
        }
        return size;
    }
}
