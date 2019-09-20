public class Print_Tree {
    //前序遍历
    public void PrintPre(TreeNodeUtil root){
        if (root!=null){
            System.out.println(root.val);
            PrintPre(root.left);
            PrintPre(root.right);
        }
    }
    //中序遍历
    public void PrintOrd(TreeNodeUtil root){
        if(root!=null){
            PrintOrd(root.left);
            System.out.println(root.val);
            PrintOrd(root.right);
        }
    }

    //后序遍历
    public void PrintLast(TreeNodeUtil root){
        if (root!=null){
            PrintLast(root.left);
            PrintLast(root.right);
            System.out.println(root.val);
        }
    }
}
