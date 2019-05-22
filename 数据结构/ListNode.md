### 链表
* 链表：后进先出
* 链表的主要操作：插入和删除
* 辅助操作：删除链表、计数、查找<p>
#### 链表和数组的优缺点：
* 数组的优点：访问元素快（常数时间）；缺点：大小固定、分配连续的空间块、基于位置的插入操作复杂
* 链表的优点：可以在常数时间进行扩展；缺点：访问单个元素开销较大（只能从头节点开始）

Note：循环链表的应用（进程使用资源的轮询算法）<br>
循环链表的操作：统计循环链表的节点个数


这部分内容包含了单向链表、双向链表和循环链表.
```
//单向链表的构建
class Node{
    private int data;
    private Node next;
    public Node(int data){this.data=data;}

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

//求单向链表长度
public int ListLength(Node head){
        if (head==null) return 0;
        int length = 0;
        Node currentNode = head;
        while (currentNode!=null) {
            length++;
            currentNode=currentNode.getNext();
        }
        return length;
    }
//从头到尾打印单向链表
public void print(Node head){
        if (head==null) return;
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.getData());
            temp=temp.getNext();
        }
    }
//在单向链表的指定位置插入节点
public Node Inorder_insert(Node head,Node newNode,int position){
        if (head==null) return newNode;
        int size = ListLength(head);
        if (position>size||position<1){
            System.out.println("插入节点失败...");
            return head;
        }
        if (position==1){
            head.setNext(newNode);
            return newNode;
        }else {
            Node preNode = head;
            int count=1;
            while (count<position-1){
                preNode=preNode.getNext();
                count++;
            }
            Node currentNode = preNode.getNext();
            newNode.setNext(currentNode);
            preNode.setNext(newNode);
        }
        return head;
    }
//删除单向链表指定位置的节点
public Node Delete_Node(Node head,int position){
        if (head==null) return null;
        int size = ListLength(head);
        if (position>size||position<1)  System.out.println("删除节点失败...");
        if (position==1){
            Node currentNode = head.getNext();
            head=null;
            return currentNode;
        }else {
            Node preNode = head;
            int count=1;
            while (count<position-1){
                preNode=preNode.getNext();
                count++;
            }
            Node currentNode = preNode.getNext();
            preNode.setNext(currentNode.getNext());
            currentNode=null;
        }
        return head;
    }
   
   
//双向链表的构建
class DLLNode{
    private int data;
    private DLLNode next;
    private DLLNode previous;
    public DLLNode(int data){this.data=data;}

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    public DLLNode getPrevious() {
        return previous;
    }
}

//插入节点到双向链表的指定位置
public DLLNode DLLInsert(DLLNode head,DLLNode insertNode,int position){
        if (head==null) return insertNode;
        int size = lengthDLLNode(head);
        if (position>size||position<1)  {
            System.out.println("插入节点失败...");
            return head;
        }
        if (position==1){
            insertNode.setNext(head);
            head.setPrevious(insertNode);
            return head;
        }else {
            DLLNode previousNode = head;
            int count=1;
            while (count<position-1){
                previousNode=previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            insertNode.setNext(currentNode);
            if (currentNode!=null){
                currentNode.setNext(insertNode);
            }
            previousNode.setNext(insertNode);
            insertNode.setPrevious(previousNode);
        }
        return head;
    }
    
    //删除双向链表的指定节点
public DLLNode DLLDelete(DLLNode head,int position){
        int size = lengthDLLNode(head);
        if (position>size||position<1){
            System.out.println("删除节点错误...");
            return head;
        }
        if (position==1){
            DLLNode currentNode = head.getNext();
            currentNode.setPrevious(null);
            return currentNode;
        }else {
            DLLNode preNode = head;
            int count=1;
            while (count<position-1){
                preNode = preNode.getNext();
                count++;
            }
            DLLNode currentNode = preNode.getNext();
            DLLNode laterNode = currentNode.getNext();
            preNode.setNext(laterNode);
            if (laterNode!=null){
                //如果被删除的节点后继节点不是null，则设置前驱
                //指向被删除节点的前驱节点
                laterNode.setPrevious(preNode);
            }
            currentNode=null;
        }
        return head;
    }
```