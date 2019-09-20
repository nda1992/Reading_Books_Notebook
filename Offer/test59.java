import java.util.ArrayList;
import java.util.Stack;

/*
* ## 对称的二叉树
如果一颗二叉树是和它的镜像是一样的，那么它是对称的
* */
public class test59 {
    public static void main(String[] args) {
        TreeNodeUtil root1 = new TreeNodeUtil(8);
        root1.setLeft(6);
        TreeNodeUtil root2 = root1.getLeft();
        root1.setRight(6);
        TreeNodeUtil root3 = root1.getRight();
        root2.setLeft(5);
        TreeNodeUtil root4 = root2.getLeft();
        root2.setRight(7);
        TreeNodeUtil root5 = root2.getRight();
        root3.setLeft(7);
        TreeNodeUtil root6 = root3.getLeft();
        root3.setRight(5);
        TreeNodeUtil root7 = root3.getRight();
        System.out.println(isSym(root1));
    }

    public static boolean isSymmetrical(TreeNodeUtil root){
        if (root==null)
            return true;
        return isSymmetrical(root.left,root.right);
    }

    public static boolean isSymmetrical(TreeNodeUtil t1,TreeNodeUtil t2){
        if (t1==t2 && t2==null)
            return true;
        if (t1==null || t2==null)
            return false;
        if (t1.val!=t2.val)
            return false;
        return isSymmetrical(t1.left,t2.right) && isSymmetrical(t1.right,t2.left);
    }


    /*
    * 方法2：非递归方法。思路：对于对称的二叉树来说，根左右的序列和根右左的序列完相同
    * 建立两个栈：stack1和stack2
    * stack1保存根左右的序列
    * stack2保存根右左的序列
    * 这两个序列分别保存到动态数组中
    * 再判断动态数组中的元素是否都相等，如果相等，则返回true，否则返回false
    * */
    public static boolean test(TreeNodeUtil root){
        if (root==null)
            return true;
        return isSym(root);
    }

    public static boolean isSym(TreeNodeUtil root){
        boolean flag = true;

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        Stack<TreeNodeUtil> stack1 = new Stack<>();
        Stack<TreeNodeUtil> stack2 = new Stack<>();

        stack1.add(root);
        while (!stack1.isEmpty()){
            TreeNodeUtil node1 = stack1.pop();
            list1.add(String.valueOf(node1.val));
            TreeNodeUtil right = node1.right;
            if (right!=null)
                stack1.push(right);
            else
                list1.add("#");
            TreeNodeUtil left = node1.left;
            if (left!=null)
                stack1.push(left);
            else
                list1.add("#");
        }

        stack2.push(root);
        while (!stack2.isEmpty()){
            TreeNodeUtil node2 = stack2.pop();
            list2.add(String.valueOf(node2.val));

            TreeNodeUtil left = node2.left;
            if (left!=null)
                stack2.push(left);
            else
                list2.add("#");
            TreeNodeUtil right = node2.right;
            if (right!=null)
                stack2.push(right);
            else
                list2.add("#");
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i)))
                continue;
            else
                flag=false;
        }
        return flag;
    }
}
