package ds.basics.array;

import java.util.Arrays;
/*
Example 1:  str1 = race; str2=care  => Anagram
Example 2:  str1 = water; str2=retaf => not anagram
*/
public class Anagram {
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        char[] charSet = new char[128];
        for(char c: str1.toCharArray()){
            charSet[c]++;
        }
        for(char c: str2.toCharArray()){
            if (charSet[c] == 0) return false;
            else charSet[c]--;
        }
        return true;
    }

    public static boolean isAnagramTest(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();
        Arrays.sort(str1Array);
        Arrays.sort(str2Array);
        return  Arrays.equals(str1Array, str2Array);
    }



    public static void main(String[] args) {
        System.out.println(isAnagram("rajeshl", "rajhes"));
        System.out.println(isAnagramTest("care", "race"));

    }

}
