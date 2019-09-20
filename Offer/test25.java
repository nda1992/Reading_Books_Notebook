import java.util.ArrayList;


/*
* 打印二叉树中结点值的和为输入整数的所有路径
* 路径定义为从树的根结点开始往下一直到叶节点所经过的结点形成的一条路径
* */
public class test25 {

    public static void main(String[] args) {
        TreeNodeUtil root1 = new TreeNodeUtil(9);
        root1.setLeft(4);
        TreeNodeUtil root2 = root1.getLeft();
        root1.setRight(1);
        TreeNodeUtil root3 = root1.getRight();
        root2.setLeft(3);
        TreeNodeUtil root4 = root2.getLeft();
        root2.setRight(2);
        TreeNodeUtil root5 = root2.getRight();
        root3.setLeft(5);
        TreeNodeUtil root6 = root3.getLeft();
        root3.setRight(6);
        TreeNodeUtil root7 = root3.getRight();

        ArrayList<ArrayList<Integer>> arrayLists = FindPath(root1, 16);

        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList);
        }


    }
    static ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNodeUtil root,int target){
        backtracking(root,target,new ArrayList<>());
        return ret;
    }

    public static void backtracking(TreeNodeUtil node,int target,ArrayList<Integer> path){
        if (node==null)
            return;
        path.add(node.val);
        target-=node.val;
        if (target==0 && node.left==null && node.right==null)
            ret.add(new ArrayList<>(path));
        else {
            backtracking(node.left,target,path);    //查找左子树
            backtracking(node.right,target,path);   //查找完左子树后，接着查找右子树
        }
        path.remove(path.size()-1);
    }

}
