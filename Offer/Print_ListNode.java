public class Print_ListNode {
    public void Print_Node(ListNodeUtil head){
        if (head==null)
            return;
        ListNodeUtil cur = head;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
