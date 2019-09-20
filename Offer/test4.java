//替换空格

public class test4 {
    public static void main(String[] args) {
        String str = "hello world spark hadoop";
        System.out.println(replaceSpace(str));
    }
    public static String replaceSpace(String str){
        if (str==null)  return null;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i)==' ')){
                stringBuffer.append(str.charAt(i));
            }else {
                stringBuffer.append('%');
                stringBuffer.append('2');
                stringBuffer.append('0');
            }
        }
        return new String(stringBuffer);
    }
}
