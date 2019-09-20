
//树的子结构：判断B树是否为A树的子结构
public class test18 {
    public static void main(String[] args) {

    }
    public static boolean SubTree(TreeNodeUtil root1,TreeNodeUtil root2){

        boolean result = false;
        if (root1!=null && root2!=null){
            //如果B的跟结点与A的根结点相等，那么继续递归判断左右子树是否也相等
            if (root1.val==root2.val){
                result = DoesSubTree(root1,root2);
            }
            if (!result){   //如果A的根结点与B不相等，则继续递归到A的左子树判断是否相等
                result=SubTree(root1.left,root2);
            }
            if (!result)    //如果A的根结点与B不相等，则继续递归到A的右子树判断是否相等
                result=SubTree(root1.right,root2);
        }
        return result;
    }

    public static boolean DoesSubTree(TreeNodeUtil root1,TreeNodeUtil root2){

        if (root2==null)    //直到判断B的左子树或右子树都是空时
            return true;
        if (root1==null)
            return false;
        if (root1.val!=root2.val)
            return false;
        //&&表左子树已经是相同的前提下，要求右子树也相同
        return DoesSubTree(root1.left,root2.left) && DoesSubTree(root1.right,root2.right);
    }
}
