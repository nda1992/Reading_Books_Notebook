//找出字符串中只出现一次的字符
public class test35 {
    public static void main(String[] args) {
        String string = "";
        System.out.println(FirstNotRepeatingChar(string));
    }
    public static char FirstNotRepeatingChar(String string) {
        if (string == null||string.length()==0) return ' ';
        int[] alaph = new int[26];

        for (int i = 0; i < string.length(); i++) {
            alaph[string.charAt(i)-'a']++;
        }
        for (int i = 0; i < alaph.length; i++) {
            if (alaph[string.charAt(i)-'a']==1)
                return string.charAt(i);
        }
        return ' ';
    }
}


