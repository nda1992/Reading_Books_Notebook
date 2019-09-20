//合并两个有序链表
public class test17 {
    public static void main(String[] args) {
        ListNodeUtil head = new ListNodeUtil(1);
        ListNodeUtil next1 = new ListNodeUtil(3);
        ListNodeUtil next2 = new ListNodeUtil(5);
        head.next=next1;
        next1.next=next2;
        next2.next=null;

        ListNodeUtil head_ = new ListNodeUtil(2);
        ListNodeUtil next1_ = new ListNodeUtil(4);
        ListNodeUtil next2_ = new ListNodeUtil(6);
        head_.next=next1_;
        next1_.next=next2_;
        next2_.next=null;

        ListNodeUtil merge = test(head, head_);
        ListNodeUtil.PrintListNode(merge);
    }

    public static ListNodeUtil Merge(ListNodeUtil list1,ListNodeUtil list2) {
        ListNodeUtil result = null;
        if(list1==null)    return list2;
        if(list2==null)    return list1;
        if(list1.val<=list2.val){
            result = list1;
            result.next=Merge(list1.next,list2);
        }else {
            result = list2;
            result.next = Merge(list2.next,list1);
        }
        return result;
    }


    //方法2：非递归实现
    public static ListNodeUtil test(ListNodeUtil list1,ListNodeUtil list2){
        ListNodeUtil result = null; //头结点
        if(list1==null)    return list2;
        if(list2==null)    return list1;

        ListNodeUtil curNode1 = list1;
        ListNodeUtil curNode2 = list2;
        ListNodeUtil temp = null;   //临时结点

        while (curNode1!=null && curNode2!=null){
            if (result==null){
                if (curNode1.val<=curNode2.val){
                    result=curNode1;
                    curNode1=curNode1.next;
                }else {
                    result=curNode2;
                    curNode2=curNode2.next;
                }
                temp=result;
            }else {
                if (curNode1.val<=curNode2.val){
                    temp.next=curNode1;
                    curNode1=curNode1.next;
                    temp=temp.next;
                }else {
                    temp.next=curNode2;
                    curNode2=curNode2.next;
                    temp=temp.next;
                }
            }
        }
        if (curNode2!=null){
           while (curNode2!=null){
               temp.next=curNode2;
               curNode2=curNode2.next;
               temp=temp.next;
           }
        }
        return result;
    }
}
