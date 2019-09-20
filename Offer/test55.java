
/*
* ## 字符流中第一个不重复的字符
* */
public class test55 {
    public static void main(String[] args) {

        System.out.println(firstUniqChar("leetcode"));
    }

    public static char firstUniqChar(String s){
        char[] chars = s.toCharArray();
        int len = s.length();
        int count = 1;
        int[] alaph = new int[26];

        for (int i = 0; i < len; i++) {
            alaph[chars[i]-'a']+=count;
        }
        for (int i = 0; i < len; i++) {
            if (alaph[chars[i]-'a']==1)
                return chars[i];
        }
        return ' ';
    }

}
