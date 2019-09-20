
//链表中环的入口结点
public class test56 {
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
        next4=next1;
        System.out.println(EntryNodeOfLoop(head).val);
    }

    public static ListNodeUtil EntryNodeOfLoop(ListNodeUtil pHead){
        if (pHead==null||pHead.next==null)
            return null;
        ListNodeUtil slow = pHead,fast = pHead;
        do {
            fast=fast.next.next;
            slow=slow.next;
        }while (slow!=fast);
        fast=pHead;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
