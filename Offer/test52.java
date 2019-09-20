
/*
* ## 构建乘积数组

给定数组A[0,1,...,n-1],构建一个数组B[0,1,...,n-1]，其中B中的元素B[i]=A[0]A[1]...A[i-1]A[i+1]A[n-1]，
不能使用除法
* */
public class test52 {
    public static void main(String[] args) {


    }


    public static int[] multiply(int[] A){
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0,product=1; i <n ;product*=A[i],i++)  {  //从左往右累乘
            B[i]=product;
        }
        for (int i = n-1,product=1; i >=0 ; product*=A[i],i--) {    //从右往左累乘
            B[i]*=product;
        }
        return B;
    }
}
