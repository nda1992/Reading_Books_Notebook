/**
 * 建立链表结点的工具类
 */
public class ListNodeUtil {
    int val;
    ListNodeUtil next;

    public ListNodeUtil(){}
    public ListNodeUtil(int val){this.val=val;}

    public void setNext(int data){ this.next=new ListNodeUtil(data);}

    public ListNodeUtil getNext(){return this.next;}

    //求链表的差长度
    public int getListNodeLength(ListNodeUtil head){
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

    //打印链表
    public static void PrintListNode(ListNodeUtil head){
        if (head==null)
            return;
        ListNodeUtil cur = head;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
