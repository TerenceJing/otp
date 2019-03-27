package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jingtiancai
 * @date: 2018/9/17 19:02
 * @desc:
 */
public class StringUtils {

    public static boolean isBlank(String str) {
        return null == str || str.replaceAll(" ", "").isEmpty() ? true : false;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static List<String> str2StrList(String s){
        if(isBlank(s)){
            return new ArrayList<>();
        }
        String[] result=s.split(",");
        return Arrays.asList(result);
    }
    public static List<Long> str2NumList(String s){
        if(isBlank(s)){
            return new ArrayList<>();
        }
        String[] array=s.split(",");
        List<Long> result=new ArrayList<>();
        for(String str:array){
            result.add(Long.parseLong(str));
        }
        return result;
    }

    /**
     *
     */
    public static String str2NBitStr(String str,String prefix,int bit){
       String result="";
        int n;
        if(isBlank(str)){
            n=bit;
        }
        if(str.length()>bit){
            return str;
        }
        n=bit-str.length();
        for(int i=0;i<n;i++){
            result+=prefix;
        }
        result+=str;
        return result;
    }
    public static String str2NBitStr(Long num,String prefix,int bit){
        return str2NBitStr(num+"",prefix,bit);
    }

}
