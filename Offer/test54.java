//表示数值的字符串
public class test54 {
    public static void main(String[] args) {
//        char[] chars = "-1E-16".toCharArray();
        System.out.println(reflectNum("12e+54"));
//        System.out.println(isNumeric(chars));
    }

//    public static boolean isNumeric(char[] str) {
//        if (str == null || str.length == 0)
//            return false;
//        int[] index = new int[1];
//        index[0] = 0; // 用于记录当前字符位置
//        // 先判断A
//        boolean isNumeric; //用于记录是否满足条件
//        isNumeric = isInteger(str, index);
//        // 判断B
//        if (index[0] < str.length && (str[index[0]] == '.')) {
//            index[0]++;
//            isNumeric = isUnsignedInteger(str, index) || isNumeric; // .B和A.和A.B形式均可以
//        }
//        // 判断e后面的A
//        if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
//            index[0]++;
//            isNumeric = isInteger(str, index) && isNumeric;
//        }
//        if (isNumeric && index[0] == str.length)
//            return true;
//        else
//            return false;
//    }
//
//    //判断是否为数字
//    private static boolean isInteger(char[] str, int[] index) { // 用int[]才能传值，int的话需要定义index为全局变量
//        if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-'))
//            index[0]++;
//        return isUnsignedInteger(str, index);
//    }
//
//    //判断是否符合无符号整数
//    private static boolean isUnsignedInteger(char[] str, int[] index) {
//        int start = index[0];
//        while (index[0] < str.length && (str[index[0]] - '0' <= 9 && str[index[0]] - '0' >= 0))
//            index[0]++;
//        if (index[0] > start)
//            return true;
//        else
//            return false;
//    }

    private static int index = 0;
    private static boolean reflectNum(String str){
        if (str==null||str.length()<=0)
            return false;
        char[] chars = str.toCharArray();
        return isNav(chars,index);
    }


    private static boolean isNav(char[] chars,int index){
        if (chars[index]=='+'||chars[index]=='-')
            index++;
        return isNum(chars,index,chars.length);
    }

    //检查e或E的前面的部分是否符合
    private static boolean isNum(char[] chars,int index,int charslen){
        while (index<charslen){
            if (chars[index]-'0'<=9 && chars[index]-'0'>=0)
                index++;
            else if (chars[index]=='.')
                index++;
            else if (chars[index]=='e'||chars[index]=='E'){
                index++;
                if (isEOre(chars,index))
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        if (index==charslen)
            return true;
        else
            return false;
    }
    //判断e或E后面的字符串是否符合
    private static boolean isEOre(char[] chars,int index){
        if (chars[index]=='+'||chars[index]=='-')
            index++;
        while (index<chars.length){
            if (chars[index]=='.')
                return false;
            else
                index++;
        }
        return true;
    }
}
