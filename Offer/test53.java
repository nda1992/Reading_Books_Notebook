
//## 正则表达式匹配
//  https://blog.csdn.net/zl18310999566/article/details/80280981
public class test53 {
    public static void main(String[] args) {

        System.out.println(Regex("aaa","ab*ac*a"));
    }


    private static boolean Regex(String string,String pattern){
        if (string==null || string.length()==0)
            return false;
        char[] chars = string.toCharArray();
        char[] pattenrs = pattern.toCharArray();
        return matchCore(chars,0,pattenrs,0);
    }

    private static boolean matchCore(char[] array,int sIndex,char[] pattern,int pIndex){
        int sLen = array.length;
        int pLen = pattern.length;

        // 字符串和模式的字符数组都已经完成了最后一个字符的匹配，说明没有出现匹配失败的情况，即匹配成功
        if (sIndex>=sLen && pIndex>=pLen)
            return true;

        // 如果模式串的每一个字符都已经参与过匹配，而字符串还有字符未匹配到，说明不匹配
        if (sIndex<sLen && pIndex>=pLen)
            return false;

        if ((pIndex+1)<pLen && pattern[pIndex+1]=='*'){
            if (sIndex>=sLen){
                return matchCore(array,sIndex,pattern,pIndex+2);
            }else {
                if (array[sIndex]==pattern[pIndex]||pattern[pIndex]=='.'){
                    return  matchCore(array,sIndex+1,pattern,pIndex+2)||
                            matchCore(array,sIndex+1,pattern,pIndex)||
                            matchCore(array,sIndex,pattern,pIndex+2);
                }else {
                    return matchCore(array,sIndex,pattern,pIndex+2);
                }
            }
        }
        if (array[sIndex]==pattern[pIndex]||(pIndex<pLen && pattern[pIndex]=='.')){
            return matchCore(array,sIndex+1,pattern,pIndex+1);
        }
        return false;
    }
}
