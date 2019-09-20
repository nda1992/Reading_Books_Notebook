import java.util.Stack;

//二叉搜索树与双向链表
/*
* 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表（要求不能创建任何新的结点，只能调整树中结点指针的指向）
*
* 思想：使用中序遍历（因为对二叉搜索树进行中序遍历得到的序列是有序的）
* */
public class test27 {
    public static void main(String[] args) {
        TreeNodeUtil root1 = new TreeNodeUtil(10);
        root1.setLeft(6);
        TreeNodeUtil root2 = root1.getLeft();
        root1.setRight(14);
        TreeNodeUtil root3 = root1.getRight();
        root2.setLeft(4);
        TreeNodeUtil root4 = root2.getLeft();
        root2.setRight(8);
        TreeNodeUtil root5 = root2.getRight();
        root3.setLeft(12);
        TreeNodeUtil root6 = root3.getLeft();
        root3.setRight(16);
        TreeNodeUtil root7 = root3.getRight();

        TreeNodeUtil convert = convert(root1);
        System.out.println(convert.val);
    }


    //递归的方法
    private static TreeNodeUtil head = null;
    private static TreeNodeUtil realHead = null;

    public static TreeNodeUtil convert(TreeNodeUtil root){
        if (root==null)
            return null;
        convert(root.left);
        if (head==null){
            head = root;
            realHead=root;
        }else {
            head.right = root;
            root.left = head;
            head = root;
        }
        convert(root.right);
        return realHead;        //相当于返回链表的头结点
    }

    //非递归方法
    public static TreeNodeUtil test(TreeNodeUtil root){
        if (root==null)
            return null;
        TreeNodeUtil list = null;
        Stack<TreeNodeUtil> stack = new Stack<TreeNodeUtil>();
        while (root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root = root.right;
            }
            else {
                root=stack.pop();
                if (list==null){        //list是一个不断变化的指针，如果最后为null，说明已经到达了链表的头部，直接返回
                    list = root;
                }else {
                    list.right = root;  //当前结点指向前一个结点（双向）
                    root.right = list;  //前一个结点指向当前结点（双向）
                    list = root;
                }
                root=root.left;
            }
        }
        return list;
    }
}
