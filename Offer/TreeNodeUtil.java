/**
 * 建立树结点的工具类
 */
public class TreeNodeUtil {
    int val;
    TreeNodeUtil left;
    TreeNodeUtil right;
    TreeNodeUtil parent;
    public TreeNodeUtil(int val){this.val=val;}
    public TreeNodeUtil(){}

    public void setLeft(int c){
        this.left=new TreeNodeUtil(c);
    }

    public void setRight(int c){
        this.right=new TreeNodeUtil(c);
    }

    public TreeNodeUtil getLeft(){
        return this.left;
    }

    public TreeNodeUtil getRight(){
        return this.right;
    }

    public void setparent (TreeNodeUtil parent){this.parent=parent;}

    public TreeNodeUtil getparent(){return this.parent;}

    public void PrintOrder(TreeNodeUtil root){
        if (root!=null){
            System.out.println(root.val);
            PrintOrder(root.left);
            PrintOrder(root.right);
        }
    }
}
