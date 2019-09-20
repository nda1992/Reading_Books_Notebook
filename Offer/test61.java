import java.util.*;

/*
* ## 按之字顺序打印二叉树
第一层按照从左到右打印，第二层按照从右到左打印，第三层按照从左到右打印，......
*
* */
public class test61 {
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

    public static ArrayList<ArrayList<Integer>> Print(TreeNodeUtil root){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNodeUtil> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-->0){
                TreeNodeUtil node = queue.poll();   //取出队列头部的元素，并移除
                if (node==null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }

            if (reverse)        //目的是分为奇数行和偶数行（如果是奇数行，则不用翻转list，若为偶数行，则需要翻转list）
                Collections.reverse(list);
            reverse=!reverse;
            if (list.size()!=0)
                ret.add(list);
        }
        return ret;
    }
}
