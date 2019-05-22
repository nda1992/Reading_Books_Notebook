### 链表
* 链表：后进先出
* 链表的主要操作：插入和删除
* 辅助操作：删除链表、计数、查找<p>
#### 链表和数组的优缺点：
* 数组的优点：访问元素快（常数时间）；缺点：大小固定、分配连续的空间块、基于位置的插入操作复杂
* 链表的优点：可以在常数时间进行扩展；缺点：访问单个元素开销较大（只能从头节点开始）

这部分内容包含了单向链表和双向链表.
```
//链表的构建
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
//从头到尾打印链表
public void print(Node head){
        if (head==null) return;
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.getData());
            temp=temp.getNext();
        }
    }
//在链表的指定位置插入节点
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
//删除链表指定位置的节点
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
```