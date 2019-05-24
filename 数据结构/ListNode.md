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

### 链表的相关问题
- 1.用链表实现栈
- 2.找到链表的第n个节点
```
public int select_n_thListNode1(Node head,int position){
        if (head==null) {
            System.out.println("链表为空，没有找到目标节点...");
            return -1;
        }

        int size = ListLength(head);
        if (position>size||position<1){
            System.out.println("输入删除位置错误，请重新输入.");
            return -1;
        }
        int k = size-position;
        int count=0;
        Node currentNode = head;
        while (count<k){
            currentNode=currentNode.getNext();
            count++;
        }
        return currentNode.getData();
    }
//方法2：只遍历一次（    设置两个指针，当前向指针找到倒数的第n个目标位置后，后向指针和前向指针通过移动，
//当前向指针到达链表尾时，后向指针的位置就是目标节点）
    public Node select_n_thListNode2(Node head,int position){
        Node pTemp = head,pNthNode = null;
        for (int x=1;x<position;x++) {
            if (pTemp != null) pTemp = pTemp.getNext();
        }
            while (pTemp!=null){
                if (pNthNode==null) pNthNode=head;
                else pNthNode=pNthNode.getNext();
                pTemp=pTemp.getNext();
            }
            if (pNthNode!=null)return pNthNode;
            return null;
        }
```
- 3.判断给定的链表是以NULL结尾还是形成一个环
```
 //使用快慢指针判断链表是否是环
 //slowPtr每次后移1个节点，fastPtr每次后移2个节点
 //类似问题：判断链表是蜗牛形结构还是蛇形结构
    public boolean DoesConListNode(Node head){
        if (head==null) return false;
        Node slowPtr=head,fastPtr=head;
        while (fastPtr.getNext()!=null && fastPtr.getNext().getNext()!=null){
            slowPtr=slowPtr.getNext();
            fastPtr=fastPtr.getNext().getNext();
            if (slowPtr==fastPtr)   return true;
        }
        return false;
    }
```
- 4.判断给定的链表是否以NULL结束，如果链表中存在环，找到环的起始节点
```
    /*
    * 在找到链表的环后，初始化slowPtr的值，使其指向链表的表头节点，然后slowPtr和fastPtr从各自的位置开始沿着链表移动，每次均移动一个节点，
    * slowPtr与fastPtr相遇的位置就是环开始的位置
    * */
    public Node FindBeginLoop(Node head){
        Node slowPtr = head,fastPtr = head;
        boolean loopExist = false;
        if (head==null) return null;
        while (fastPtr.getNext()!=null && fastPtr.getNext().getNext()!=null){
            slowPtr=slowPtr.getNext();
            fastPtr=fastPtr.getNext().getNext();
            if (slowPtr==fastPtr)   loopExist=true;
            break;
        }
        if (loopExist){
            slowPtr=head;
            while (slowPtr!=fastPtr){
                fastPtr=fastPtr.getNext();
                slowPtr=slowPtr.getNext();
            }
            return slowPtr;
        }
        return null;
    }
```
- 5.判断给定的链表是否以NULL结束，如果链表中存在环，返回环的长度
```
    /*
    *在找到链表的环后，初始化slowPtr的值，使其指向链表的表头节点，保持slowPtr不动，fastPtr指针继续移动，每次移动fastPtr时，计数器+1，直到再次回到slowPtr指针所在的位置
    * 即可求出环的长度
    * */
    public int FindLoopLength(Node head){
        Node slowPtr = head,fastPtr = head;
        boolean loopExist = false;
        int count=0;
        if (head==null){
            return 0;
        }
        while (fastPtr.getNext()!=null && fastPtr.getNext().getNext()!=null){
            slowPtr=slowPtr.getNext();
            fastPtr=fastPtr.getNext().getNext();
            if (fastPtr==slowPtr)loopExist=true;
            break;
        }
        if (loopExist){
            fastPtr=fastPtr.getNext();
            while (slowPtr!=fastPtr){
                fastPtr=fastPtr.getNext();
                count++;
            }
            return count;
        }
        return 0;
    }
```
- 6.在有序链表中插入一个节点
```
public Node InsertSortedList(Node head,Node newNode){
        Node currentNode = head;
        Node temp=null;
        if (head==null) return newNode;
        //遍历链表，直至找到比新节点对应数值更大的节点
        while (currentNode!=null&&currentNode.getData()<newNode.getData()){
            temp=currentNode;
            currentNode=currentNode.getNext();
        }
        newNode.setNext(currentNode);
        temp.setNext(newNode);
        return head;
    }
```
- 7.逆至单向链表
```
public Node ReserveList(Node head){
        Node temp=null,nextNode = null;
        while (head!=null){
            nextNode=head.getNext();
            head.setNext(temp); //头节点指向null
            temp=head;
            head=nextNode;
        }
        return temp;
    }
```
- 8.假设两个链表在某个节点相交后，组成一个单向链表，找到两个单向链表的的合并节点
```

```
- 9.找到链表的中间节点
```

```
- 10.检查链表的长度是奇数还是偶数
```

```
- 11.把两个有序链表组合成一个有序链表
```

```
- 12.逐对逆至链表
```

```
- 13.将给定的二叉树转换为双向链表
```

```
- 14.
