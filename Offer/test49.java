
//将字符串转换为整数
public class test49 {
    public static void main(String[] args) {
        System.out.println(StrToInt("-105"));
    }

    public static int StrToInt(String str){
        if (str==null || str.length()==0)
            return 0;
        boolean isNegative = str.charAt(0)=='-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i==0 && (c=='+' || c=='-'))
                continue;
            if (c<'0' || c>'9')
                return 0;
            //'0'的ASCII码为48，所以只要使用字符c对应的ASCII码与'0'作差，就能求出c所表示的十进制数值
            ret=ret*10+(c-'0');
        }
        return isNegative?-ret:ret;
    }

}
