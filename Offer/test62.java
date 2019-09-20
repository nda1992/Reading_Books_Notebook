//序列化二叉树:实现将二叉树序列化和反序列化
public class test62 {
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


        String serialize = Serialize(root1);
        System.out.println(serialize);
//
//        TreeNodeUtil deserialize = Deserialize(serialize);
//        Print_Tree print_tree = new Print_Tree();
//        print_tree.Print(deserialize);
    }

    private static String deserializeStr;

    public static String Serialize(TreeNodeUtil root){      //使用前序遍历，首先对根节点序列化，再对左子树序列化，最后再对右子树序列化
        if (root==null)
            return "#";
        return root.val+" "+ Serialize(root.left)+" "+Serialize(root.right);
    }

    public static TreeNodeUtil Deserialize(String str){
        deserializeStr = str;
        return Deserialize();
    }

    public static TreeNodeUtil Deserialize(){
        if (deserializeStr.length()==0)
            return null;
        int index = deserializeStr.indexOf(" ");    //取得当前字符索引

        //根据索引找到对应的字符(因为deserializeStr是静态的，所以该操作每次都将会取到该字符串的第一个字符)
        String node = index==-1?deserializeStr:deserializeStr.substring(0,index);

        //保存deserializeStr的index+1所以后的字符串
        deserializeStr = index ==-1?"":deserializeStr.substring(index+1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNodeUtil t = new TreeNodeUtil(val);
        t.left = Deserialize();     //递归反序列化左子树
        t.right = Deserialize();    //递归反序列化右子树
        return t;
    }





}
