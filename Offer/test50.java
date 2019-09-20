import java.util.ArrayList;
import java.util.Stack;


//## 二叉树中两个结点的最近公共祖先
public class test50 {
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

        TreeNodeUtil parent = getParent(root1, root3, root7);
        System.out.println(parent.val);

    }

    public static TreeNodeUtil getParent(TreeNodeUtil root,TreeNodeUtil node1,TreeNodeUtil node2){
        ArrayList<TreeNodeUtil> rootPath1 = getRootPath1(root, node1);
        ArrayList<TreeNodeUtil> rootPath2 = getRootPath2(root, node2);

        if (rootPath1!=null && rootPath2!=null){
            int size1 = rootPath1.size();
            int size2 = rootPath2.size();

            if (size1<=size2){      //比较不同长度数组中的元素：照顾长度较小的数组
                for (int i = 0; i < size1; i++) {
                    if (rootPath1.get(i)==rootPath2.get(i)){    //找到最近的公共祖先
                        continue;
                    }else{
                        return rootPath1.get(i-1);
                    }
                }
                return rootPath1.get(size1-1);  //以上都不符合时，根结点是最近公共祖先
            }else{
                for (int i = 0; i < size2; i++) {
                    if (rootPath1.get(i)==rootPath2.get(i)){
                        continue;
                    }else{
                        return rootPath2.get(i-1);
                    }
                }
                return rootPath2.get(size2-1);
            }
        }
        return null;
    }
    //寻找从根节点到node1的路径
    public static ArrayList<TreeNodeUtil> getRootPath1(TreeNodeUtil root,TreeNodeUtil node1){
        if (root==null || node1==null)
            return null;
        Stack<TreeNodeUtil> stack = new Stack<>();

        ArrayList<TreeNodeUtil> path1 = new ArrayList<>();
        TreeNodeUtil temp = root;
        TreeNodeUtil pre = null;

        //这个while循环的思想还是一直往左找，找的过程结点入栈
        while (temp!=null || !stack.isEmpty()){
            while (temp!=null){
                stack.push(temp);
                if (temp.val==node1.val){
                    for (TreeNodeUtil treeNodeUtil : stack) {
                        path1.add(treeNodeUtil);
                    }
                    return path1;
                }
                temp=temp.left;
            }
            //走到这一步说明栈顶元素的左子树为null，那么就开始往栈顶元素的右子树上去找
            if (!stack.isEmpty()){
                temp = stack.peek();
                //如果栈顶元素的右子树为null，或者右子树被遍历过，则弹栈
                while (temp.right==null || pre!=null && temp.right==pre){   //pre!=null && temp.right==pre指的是是否已经被访问过
                    pre=stack.pop();
                    temp=stack.peek();
                }
                //继续遍历p的右子树
                temp=temp.right;
            }
        }
        return null;
    }
    //寻找从根节点到node2的路径
    public static ArrayList<TreeNodeUtil> getRootPath2(TreeNodeUtil root,TreeNodeUtil node2){
        if (root==null || node2==null)
            return null;
        Stack<TreeNodeUtil> stack = new Stack<>();

        ArrayList<TreeNodeUtil> path2 = new ArrayList<TreeNodeUtil>();
        TreeNodeUtil temp = root;
        TreeNodeUtil pre = null;

        while (temp!=null || !stack.isEmpty()){
            while (temp!=null){
                stack.push(temp);
                if (temp.val==node2.val){
                    for (TreeNodeUtil treeNodeUtil : stack) {
                        path2.add(treeNodeUtil);
                    }
                    return path2;

                }
                temp=temp.left;
            }
            if (!stack.isEmpty()){
                temp = stack.peek();
                while (temp.right==null || pre!=null && temp.right==pre){
                    pre=stack.pop();
                    temp=stack.peek();
                }
                temp=temp.right;
            }
        }
        return null;
    }
}
