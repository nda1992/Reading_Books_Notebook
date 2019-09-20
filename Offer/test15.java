
//查找链表中的倒数第k个节点
public class test15 {
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
        System.out.println(test(head,1).val);

    }

    //方法1，设定两个指针
    public static ListNodeUtil FindKthToTail(ListNodeUtil head,int k){
        if (head==null)
            return null;
        ListNodeUtil P1 = head;
        while (P1!=null && k-->0){
            P1=P1.next;
        }
        if (k>0)
            return null;
        ListNodeUtil P2 = head;
        while (P1!=null){
            P1=P1.next;
            P2=P2.next;
        }
        return P2;
    }

    //方法2：先求出链表长度，再获取倒数第k个节点
    public static ListNodeUtil test(ListNodeUtil head,int k){
        if (head==null)
            return null;

        int count = getLength(head)-k;
        int m=1;
        ListNodeUtil cur = head;
        while (cur!=null && m<=count){
            cur=cur.next;
            m++;
        }
        return cur;
    }

    public static int getLength(ListNodeUtil head){
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
