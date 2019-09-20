
/*
* ## 孩子们的游戏（圆圈中最后剩下的数）
从0开始，每次从这个圆圈中删除第m个数字，求这个圆圈中剩下的最后一个数字

规律：
当n=1，返回0；
当n>1，返回[f(n-1,m)+m]%n
其中f(n-1,m)是关于n和m的方程

递归方法：要得到n个数字剩下的最后一个数字，只需要得到n-1个数字序列中的最后一个数字，以此类推......
* */
public class test45 {
    public static void main(String[] args) {

        System.out.println(LastRemaining_Number(6,3));
    }

    public static int LastRemaining_Number(int n,int m){
        if (n==0)
            return -1;
        if (n==1)
            return 0;
//        return (LastRemaining_Number(n-1,m)+m)%n;

        int last = 0;
        for (int i = 2; i <=n ; i++) {
            last = (last+m)%i;
        }
        return last;
    }

}
