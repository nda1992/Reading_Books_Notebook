//判断一个链表是以null结尾还是形成一个环
public class test73 {
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
        next4.setNext(6);
        ListNodeUtil next5 = next4.getNext();
        next5.setNext(7);
        ListNodeUtil next6 = next5.getNext();
        next6.next=next3;
        System.out.println(DoesLinkContainsLoop(head));
    }


    public static boolean DoesLinkContainsLoop(ListNodeUtil head){
        if (head==null)
            return false;
        ListNodeUtil slow = head,fast = head;
        while ((fast.getNext()!=null&&fast.getNext().getNext()!=null)){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if (slow==fast)
                return true;
        }
        return false;
    }
}
