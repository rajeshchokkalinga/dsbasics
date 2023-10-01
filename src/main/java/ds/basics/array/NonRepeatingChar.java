package ds.basics.array;

import java.util.HashMap;
import java.util.Map;

// Java program to find first  non-repeating character
class NonRepeatingChar {
    static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];

    /* calculate count of characters in the passed string */
    static void getCharCountArray(String str)
    {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
    }

    /* The method returns index of first non-repeating
       character in a string. If all characters are repeating
       then returns -1 */
    static int firstNonRepeating(String str)
    {
        getCharCountArray(str);
        int index = -1, i;

        for (i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }

    // Driver method
    public static void main(String[] args)
    {
        String str = "today is Friday today";
        int index = firstNonRepeating(str);

        System.out.println(
              index == -1
                    ? "Either all characters are repeating or string "
                    + "is empty"
                    : "First non-repeating character is "
                    + str.charAt(index));

        //Finding using Hashmap
        Map<Character, Integer > nonrepeat = new HashMap<>();
        for(char c:str.toCharArray()){
            if(nonrepeat.get(c) == null)
            nonrepeat.put(c,  1);
            else
                nonrepeat.put(c,  nonrepeat.get(c)+1);
        }

        for(char c:str.toCharArray()){
            if(nonrepeat.get(c) == 1) {
                System.out.println("First Repeating Char: "+ c );
                break;
            }

        }
        int a = 33; int b = 10;
        System.out.printf("Before swap 'a': %d, 'b': %d %n", a, b);
        a = (a + b) - (b = a);
        System.out.printf("After swapping, 'a': %d, 'b': %d %n", a, b);


    }
}