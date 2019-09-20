/*
* 求二叉树的深度
*
* */
public class test39 {
    public static void main(String[] args) {
        TreeNodeUtil root1 = new TreeNodeUtil(1);
        root1.setLeft(2);
        TreeNodeUtil root2 = root1.getLeft();
        root1.setRight(3);
        TreeNodeUtil root3 = root1.getRight();
        root2.setLeft(4);
        TreeNodeUtil root4 = root2.getLeft();
        root2.setRight(5);
        TreeNodeUtil root5 = root2.getRight();
        root3.setLeft(6);
        TreeNodeUtil root6 = root3.getLeft();
        root3.setRight(7);
        TreeNodeUtil root7 = root3.getRight();
        root7.setRight(8);
        TreeNodeUtil root8 = root7.getRight();

        System.out.println(TreeDepth(root1));
    }

    public static int TreeDepth(TreeNodeUtil root){
        return root==null?0:1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }
}
