import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 输入ABC输出它的全排列：
    ABC\ACB\BCA\BAC\CBA\CAB\
* */
public class test28_ {
    public static void main(String[] args) {
        String[] strings = {"ABC","ACB","BAC","BCA","CAB"};
        System.out.println(test(strings,"ABC"));
    }

    static ArrayList<String> ret = new ArrayList<>();

    public static String test(String[] strings,String string){
        List<String> temp =Arrays.asList(strings);
        String str = null;
        ArrayList<String> ret = Permutation(string);
        for (int i = 0; i < ret.size(); i++) {
            if (!temp.contains(ret.get(i)))
                str=ret.get(i);
        }
        return str;
    }

    public static ArrayList<String> Permutation(String str){
        if (str.length()==0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars,new boolean[chars.length],new StringBuilder());
        return ret;
    }

    public static void backtracking(char[] chars,boolean[] hasUsed,StringBuilder s){
        if (s.length()==chars.length){
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i!=0 && chars[i]==chars[i-1] && !hasUsed[i-1])
                continue;
            hasUsed[i]=true;
            s.append(chars[i]);
            backtracking(chars,hasUsed,s);
            s.deleteCharAt(s.length()-1);
            hasUsed[i]=false;
        }
    }
}
