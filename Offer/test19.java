
//求一棵树的镜像
public class test19 {
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
        Mirror(root1);
        Print_Tree print_tree = new Print_Tree();
        print_tree.PrintPre(root1);
    }

    public static void Mirror(TreeNodeUtil root){
        if (root==null)
            return;
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void swap(TreeNodeUtil root){
        TreeNodeUtil t = root.left;
        root.left=root.right;
        root.right=t;
    }
}
