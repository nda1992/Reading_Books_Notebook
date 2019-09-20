public class test71 {
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
        root7.setLeft(8);
        TreeNodeUtil root8 = root7.getLeft();
        root8.setLeft(9);

        System.out.println(IsBalance_Solution(root1));
    }

    /*
     * 输入一颗二叉树，判断该二叉树是否是平衡的(任意结点的左子树和右子树之差的绝对值不大于1)
     * */
    static boolean isBalance = true;

    public static boolean IsBalance_Solution(TreeNodeUtil root){
        height(root);
        return isBalance;
    }

    public static int height(TreeNodeUtil root){
        if (root==null || !isBalance){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left-right)>1)
            isBalance=false;
        return 1+Math.max(left,right);
    }

}
