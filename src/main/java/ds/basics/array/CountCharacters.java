package ds.basics.array;

import java.util.Arrays;

/**
 * Java program to count the number of occurrences of any character on String.
 Example

 String input = "Today is Monday";

 output:
 ======
 count:2
 M count:1
 T count:1
 a count:2
 d count:2
 i count:1
 n count:1
 o count:2
 s count:1
 y count:2*/


public class CountCharacters {

    public static void main(String args[]) {
        String input = "Today is Monday";
        printCountOfChars(input);
    }

    private static void printCountOfChars(String input){
        char[] count = new char[256];
        char[] stringArray = input.toCharArray();
       // Arrays.sort(stringArray);
        for (char ch : stringArray) {
            count[ch]++;
        }

        String tmp = "";
        for (char c : stringArray) {
            if(!tmp.contains(c+""))
                System.out.println(c + " count:" + (int) count[c]);
            tmp+=c;
        }
    }

}
