import java.util.ArrayList;
import java.util.HashSet;

/*
* ## 字符串的排列

输入abc，输出它的所有排列字符串：abc，acb，bac，bca，cab，cba
* */
public class test28 {
    public static void main(String[] args) {
        ArrayList<String> string = Permutation("abc");
        System.out.println(string);
    }


//    private static ArrayList<String> ret;
//
//    public static ArrayList<String> Permutation(String str){
//        if (str.length()==0)
//            return ret;
//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
//        backtrcking(chars,new boolean[chars.length],new StringBuilder());
//        return ret;
//
//    }
//
//    private static void backtrcking(char[] chars,boolean[] hasUsed,StringBuilder s){
//        if (s.length()==chars.length){
//            ret.add(s.toString());
//            return;
//        }
//        for (int i = 0; i < chars.length; i++) {
//            if (hasUsed[i])
//                continue;
//            if (i!=0 && chars[i]==chars[i-1] && !hasUsed[i-1]) //保证不重复
//                continue;
//            hasUsed[i]=true;
//
//            s.append(chars[i]);
//            backtrcking(chars,hasUsed,s);
//            s.deleteCharAt(s.length()-1);
//            hasUsed[i]=false;
//        }
//    }

    public static ArrayList<String> Permutation(String str){
        char[] data = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        Permutation(data,0,result);
        HashSet<String> set = new HashSet<>();
        set.addAll(result);
        result.clear();
        result.addAll(set);
        return result;
    }
    public static void Permutation(char[] data,int begin,ArrayList<String> result){
        //如果已经交换到最后一位，那么将这个字符串添加进结果集合
        if (begin==data.length-1)
            result.add(new String(data));
        else {
            for (int i = begin; i < data.length; i++) {
                // 如果第i个元素和开始的元素相同，则两个元素就不交换
                if (i!=begin&&data[i]==data[begin])
                    continue;
                char temp = data[begin];
                data[begin]=data[i];
                data[i]=temp;

                Permutation(data,begin+1,result);

                temp = data[begin];
                data[begin]=data[i];
                data[i]=temp;
            }
        }
    }
}
