//class utils {
//    //创建一个含有6个节点的链表
//    public ListNode getListNode(){
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        listNode1.next=listNode2;
//        ListNode listNode3 = new ListNode(3);
//        listNode2.next=listNode3;
//        ListNode listNode4 = new ListNode(4);
//        listNode3.next=listNode4;
//        ListNode listNode5 = new ListNode(5);
//        listNode4.next=listNode5;
//        ListNode listNode6 = new ListNode(6);
//        listNode5.next=listNode6;
//        listNode6=null;
//        return listNode1;       //返回链表的头结点
//    }
//
//    //创建一个含有3个节点的链表
//    public ListNode getListNode1(){
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(4);
//        listNode1.next=listNode2;
//        ListNode listNode3 = new ListNode(3);
//        listNode2.next=listNode3;
//        return listNode1;
//    }
//    //创建一个含有3个节点的链表
//    public ListNode getListNode2(){
//        ListNode listNode1 = new ListNode(5);
//        ListNode listNode2 = new ListNode(6);
//        listNode1.next=listNode2;
//        ListNode listNode3 = new ListNode(4);
//        listNode2.next=listNode3;
//        return listNode1;
//    }
//}
//
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x){val=x;}
//
//    public void getTreeNode(){
//        TreeNode root = new TreeNode(3);
//        root.left=new TreeNode(1);
//        root.right=new TreeNode(2);
//    }
//    public TreeNode(){}
//}
//
//class TreeNode1{
//    char val;
//    TreeNode1 left;
//    TreeNode1 right;
//    TreeNode1(char x){val=x;}
//
//    public void getTreeNode(){
//        TreeNode1 root = new TreeNode1('a');
//        root.left=new TreeNode1('b');
//        root.right=new TreeNode1('c');
//    }
//    public TreeNode1(){}
//}
//
////双向链表的结构
//class DLLNode{
//    int data;
//    DLLNode next;
//    DLLNode previous;
//    public DLLNode(){}
//    public DLLNode(int data){this.data=data;}
//
//    public DLLNode getDLLNode(){
//        DLLNode dllNode1 = new DLLNode(1);
//        DLLNode dllNode2 = new DLLNode(2);
//        dllNode1.next=dllNode2;
//        dllNode2.previous=dllNode1;
//        DLLNode dllNode3 = new DLLNode(3);
//        DLLNode dllNode4 = new DLLNode(4);
//        dllNode2.next=dllNode3;
//        dllNode3.previous=dllNode2;
//        dllNode3.next=dllNode4;
//        dllNode4.previous=dllNode3;
//        dllNode4.next=null;
//        return dllNode1;
//    }
//}
//
//class CLLNode{
//    int data;
//    CLLNode next;
//    public CLLNode(){}
//    public CLLNode(int data){
//        this.data=data;
//    }
//    public CLLNode getCLLNode(){
//        CLLNode headNode = new CLLNode(1);
//        CLLNode cllNode1 = new CLLNode(2);
//        CLLNode cllNode2 = new CLLNode(3);
//        CLLNode cllNode3 = new CLLNode(4);
//        CLLNode cllNode4 = new CLLNode(5);
//        headNode.next=cllNode1;
//        cllNode1.next=cllNode2;
//        cllNode2.next=cllNode3;
//        cllNode3.next=cllNode4;
//        cllNode4.next=headNode;
//        return headNode;
//    }
//
//    public void PrintCLLNode(CLLNode cllNode){
//        if (cllNode==null)
//            return;
//        CLLNode currentNode = cllNode;
//        while (currentNode!=null){
//            System.out.println(currentNode.data);
//            currentNode=currentNode.next;
//            if (currentNode==cllNode)
//                break;
//        }
//    }
//}
//
//
//
