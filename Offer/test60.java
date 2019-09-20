import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
* ## 把二叉树打印成多行

从上到下打印二叉树，用一层节点按从左到右打印，每层打印一行
* */
public class test60 {
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

        ArrayList<ArrayList<Integer>> arrayLists = Print(root1);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList);
        }

    }

    //这道题与test14类似，但是比test14简单
    public static ArrayList<ArrayList<Integer>> Print(TreeNodeUtil root){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNodeUtil> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-->0){
                TreeNodeUtil node = queue.poll();
                if (node==null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size()!=0)
                ret.add(list);
        }
        return ret;
    }

}
