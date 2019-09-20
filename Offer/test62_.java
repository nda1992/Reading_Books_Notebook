import java.util.Stack;

//非递归实现序列化二叉树
public class test62_ {
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

        String s = Serialize(root1);
        TreeNodeUtil treeNodeUtil = DeSerialize();
        TreeNodeUtil t = new TreeNodeUtil();
        t.PrintOrder(treeNodeUtil);
    }


    private static StringBuffer sb = new StringBuffer();
    public static String Serialize(TreeNodeUtil root){
        if (root==null)
            return null;
        Stack<TreeNodeUtil>  stack= new Stack<>();
        stack.add(root);

        while (root!=null && !stack.isEmpty()){
            TreeNodeUtil treeNodeUtil = stack.pop();
            if (treeNodeUtil.left==null){
                sb.append(treeNodeUtil.val);
                sb.append(",");
                sb.append("#");
                sb.append(",");
            } else
            {
                sb.append(treeNodeUtil.val);
                sb.append(",");
            }
            if (treeNodeUtil.right==null){
                sb.append("#");
                sb.append(",");
            }
            TreeNodeUtil right = treeNodeUtil.right;
            if (right!=null)
                stack.push(right);
            TreeNodeUtil left = treeNodeUtil.left;
            if (left!=null)
                stack.push(left);
        }
        return new String(sb);
    }

    public static TreeNodeUtil DeSerialize(){
        if (sb.length()==0)
            return null;
        int index = sb.indexOf(",");
        StringBuffer node = index==-1?sb:new StringBuffer(sb.substring(0,index));
        sb = index==-1?new StringBuffer(""):new StringBuffer(sb.substring(index+1));

        if (node.toString().equals("#")){
            return null;
        }
        int val = Integer.valueOf(node.toString());
        TreeNodeUtil t = new TreeNodeUtil(val);
        t.left = DeSerialize();
        t.right = DeSerialize();
        return t;
    }

}
