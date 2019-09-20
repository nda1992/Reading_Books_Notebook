
/*
* 二叉搜索树的后序遍历序列
* 判断一个数组是否是某二叉搜索树的后序遍历结果
* */
public class test24 {
    public static void main(String[] args) {
        int[] arr = {5,7,6,9,11,12,8};
        System.out.println(VerifySequenceOfBST(arr));
    }

    public static boolean VerifySequenceOfBST(int[] sequence){
        if (sequence==null || sequence.length==0)
            return false;
        return verify(sequence,0,sequence.length-1);
    }

    public static boolean verify(int[] sequence,int first,int last){
        if (last-first<=1)
            return true;
        int rootVal = sequence[last];   //取最后一个元素
        int cutIndex = first;
        //找到能分开左右两部分的索引（即要求左边部分都小于rootVal，右边部分都大于rootVal）
        while (cutIndex<last && sequence[cutIndex]<=rootVal)
            cutIndex++;
        for (int i = cutIndex; i < last; i++) {
            if (sequence[i]<rootVal)
                return false;
        }
        return verify(sequence,first,cutIndex-1) && verify(sequence,cutIndex,last-1);
    }
}
