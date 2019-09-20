public class test9__ {
    public static void main(String[] args) {
        System.out.println(RectCover(8));
    }

    public static int RectCover(int n){
        if (n<=2)
            return n;
        int pre2=1,pre1=2;
        int result = 0;
        for (int i = 3; i <=n ; i++) {
            result=pre2+pre1;
            pre2=pre1;
            pre1=result;
        }
        return result;
    }

}
