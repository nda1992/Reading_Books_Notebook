
/*
* ## 二叉树的下一个结点
给定一颗二叉树和其中一个节点，找出中序遍历序列中的下一个节点

分为三种情况：
- 如果该节点有右子树，则它的下一个节点就是它右子树的最左子结点
- 如果该节点没有右子树，但它是父节点的左子节点，则它的下一个节点就是它的父节点
- 如果该节点没有右子树，并且它是父节点的右子结点，则需要向上遍历寻找，
直到找到一个是它父节点的左结点的节点（即向上寻找，如果找到的节点是它的父节点的
左子节点，那么他就是所求的节点）.
* */
public class test58 {
    public static void main(String[] args) {

        TreeNodeUtil root1 = new TreeNodeUtil(1);
        root1.setparent(null);
        root1.setLeft(2);
        TreeNodeUtil root2 = root1.getLeft();
        root2.setparent(root1);
        root1.setRight(3);
        TreeNodeUtil root3 = root1.getRight();
        root3.setparent(root1);
        root2.setLeft(4);
        TreeNodeUtil root4 = root2.getLeft();
        root4.setparent(root2);
        root2.setRight(5);
        TreeNodeUtil root5 = root2.getRight();
        root5.setparent(root2);
        root3.setLeft(6);
        TreeNodeUtil root6 = root3.getLeft();
        root6.setparent(root3);
        root3.setRight(7);
        TreeNodeUtil root7 = root3.getRight();
        root7.setparent(root3);

        System.out.println(GetNext(root5).val);

    }
    public static TreeNodeUtil GetNext(TreeNodeUtil pNode){

        if (pNode==null)
            return null;
        TreeNodeUtil pNext = null;
        if (pNode.right!=null){
            TreeNodeUtil pRight = pNode.right;
            while (pRight.left != null)
                pRight = pRight.left;
            return pRight;

        }else if (pNode.parent!=null){
            TreeNodeUtil pCurrent = pNode;
            TreeNodeUtil pParent = pNode.parent;
            while (pParent!=null && pCurrent==pParent.right){
                pCurrent=pParent;
                pParent=pParent.parent;
            }
            pNext = pParent;
        }
        return pNext;
    }

}
