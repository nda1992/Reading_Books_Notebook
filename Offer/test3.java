
//二维数组中的查找
public class test3 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] a={{}};
        System.out.println(test(a,17));
    }

    public static boolean test(int[][] data,int target){
        if ((data==null || data.length==0)||(data.length==1&&data[0].length==0))
            return false;

        boolean found = false;
        //X轴
        int X = 0;
        //Y轴
        int Y = 0;

        for (int i = 0; i <data[0].length ; i++) {
            Y++;    //X轴计数
        }
        for (int i = 0; i < data[1].length; i++) {
            X++;    //Y轴计数
        }

        if (X>0 && Y>0){
            int lenX = 0;
            int lenY = Y-1;

            while (lenX<X && lenY>0){
                if (data[lenX][lenY]==target){
                    found=true;
                    return found;
                }else if (data[lenX][lenY]>target)
                    lenY--;     //如果大于该值，把该值对应的列删除，即往右移动一列，lenY--
                else
                    lenX++;     //如果小于该值，把该值对应的行删除，即往下移动一行，lenX++
            }
        }
        return found;
    }

}
