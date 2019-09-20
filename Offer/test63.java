
//二叉搜索树的第k个结点
//给定一颗二叉搜索树，找出其中第k大的结点
//思想：使用中序遍历(因为中序遍历二叉搜索树的序列是有序的)得到一个有序的序列，接着再求得第k大的结点

import java.util.ArrayList;
import java.util.Stack;

public class test63 {
    public static void main(String[] args) {
        TreeNodeUtil root1 = new TreeNodeUtil(5);
        root1.setLeft(3);
        TreeNodeUtil root2 = root1.getLeft();
        root1.setRight(7);
        TreeNodeUtil root3 = root1.getRight();
        root2.setLeft(2);
        TreeNodeUtil root4 = root2.getLeft();
        root2.setRight(4);
        TreeNodeUtil root5 = root2.getRight();
        root3.setLeft(6);
        TreeNodeUtil root6 = root3.getLeft();
        root3.setRight(8);
        TreeNodeUtil root7 = root3.getRight();


        System.out.println(KthNodeSmall(root1,1).val);

    }
    //递归实现(求第k小的结点)
    private static TreeNodeUtil ret;
    private static int cnt = 0;
    public static TreeNodeUtil KthNodeSmall(TreeNodeUtil root,int k){
        inOrder(root,k);
        return ret;
    }
    private static void inOrder(TreeNodeUtil root,int k){
        if (root==null || cnt>=k)
            return;
        inOrder(root.left,k);
        cnt++;
        if (cnt==k)
            ret = root;
        inOrder(root.right,k);
    }

    //非递归实现
    public static TreeNodeUtil test(TreeNodeUtil root,int k){
        if (root==null || k<=0)
            return null;

        //定义栈,临时结点
        Stack<TreeNodeUtil> stack = new Stack<>();
        //定义动态数组，保存中序遍历序列
        ArrayList<TreeNodeUtil> nodes = new ArrayList<>();

        if (root==null)
            return null;

        TreeNodeUtil p = root;

        while (p!=null || !stack.isEmpty()){
            //如果p不为空，找到最左边的结点，经过的结点全部入栈
            if (p!=null){
                stack.push(p);
                p=p.left;
            }else {
                p=stack.pop();
                nodes.add(p);
                p=p.right;
            }
        }

        if (k>nodes.size())
            return null;

        for (int i = nodes.size()-1; i >=0; i--) {
            k--;
            if (k==0)
                return nodes.get(i);
        }
        return null;
    }
}
