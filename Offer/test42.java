public class test42{
    public static void main(String[] args) {
        String s = "abcXYZdef";
        System.out.println(LeftRotateString(s,3));


        String string = "i am a student.";
        System.out.println(ReverseSentence(string));
    }

    public static String LeftRotateString(String str,int n){
        if (n>=str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars,0,n-1);       //翻转前n个字符
        reverse(chars,n,chars.length-1);    //翻转字符串的后面部分
        reverse(chars,0,chars.length-1);    //翻转整个字符串
        return new String(chars);

    }


    public static void reverse(char[] chars,int i,int j){
        while (i<j)
            swap(chars,i++,j--);
    }

    public static void swap(char[] chars,int i,int j){
        char t = chars[i];
        chars[i]=chars[j];
        chars[j]=t;
    }

    //反转整个句子的单词序列
    //i am a student-->student. a am i
    public static String ReverseSentence(String string){
        int n = string.length();
        char[] chars = string.toCharArray();
        reverse(chars,0,n-1);
        int j = 0;
        int i = 0;
        while (j<=n-1){
            if (chars[j]==' ') {    //遇到空格就反转
                reverse(chars,i,j-1);
                j++;
                i=j;
            }
            j++;
        }
        return new String(chars);
    }
}
