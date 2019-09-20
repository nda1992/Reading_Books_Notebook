import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
* ## 从上往下打印二叉树
使用队列
* */
public class test23 {
    public static void main(String[] args) {

    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNodeUtil root){
        Queue<TreeNodeUtil> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNodeUtil t = queue.poll();
            arrayList.add(t.val);
            if (t.left!=null)
                queue.add(t.left);
            if (t.right!=null)
                queue.add(t.right);
        }
        return arrayList;
    }

    public static ArrayList<Integer> test(TreeNodeUtil root){
        Queue<TreeNodeUtil> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNodeUtil t = queue.poll();
            arrayList.add(t.val);
            if (t.left!=null)
                queue.add(t.left);
            if (t.right!=null)
                queue.add(t.right);
        }
        return arrayList;
    }
}
