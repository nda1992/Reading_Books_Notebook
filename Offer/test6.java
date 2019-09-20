//重建二叉树
public class test6 {
    public static void main(String[] args) {
        int[] PreOrder = {1,2,4,7,3,5,6,8};
        int[] InOrder = {4,7,2,1,5,3,8,6};
        TreeNodeUtil root = Solution(InOrder,PreOrder,0,InOrder.length-1);

        Print_Tree pt = new Print_Tree();
        pt.PrintPre(root);
        System.out.println("--------------");
        pt.PrintOrd(root);
        System.out.println("--------------");
        pt.PrintLast(root);
    }

    static int preIndex = 0;
    public static TreeNodeUtil Solution(int[] InOrder, int[] PreOrder, int inStart, int inEnd){

        TreeNodeUtil newNode = new TreeNodeUtil();
        if (inStart>inEnd)
            return null;
        if (newNode==null){
            System.out.println("内存出错");
            return null;
        }
        //使用preIndex在前序序列中选择当前结点
        newNode.val=PreOrder[preIndex];
        preIndex++;
        if (inStart==inEnd) //若左右都没有节点，直接返回
            return newNode;
        //在中序序列中找到该结点的索引
        int inIndex = SearchInOrderIndex(InOrder,inStart,inEnd,newNode.val);    //根据中序遍历和结点值求索引
        //使用中序序列中结点的索引分别建立左子树和右子树
        newNode.left=Solution(InOrder,PreOrder,inStart,inIndex-1);  //递归左子树
        newNode.right=Solution(InOrder,PreOrder,inIndex+1,inEnd);  //递归右子树
        return newNode;
    }
    //查找索引的函数
    public static int SearchInOrderIndex(int[] inorder,int instart,int inend,int data){
        int k=0;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i]==data)
                return i;
        }
        return k;
    }
}
