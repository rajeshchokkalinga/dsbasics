package ds.basics.leetcode;

import java.util.HashMap;

/**
      Example 1: Input: s = "III"  Output: 3

      Example 2:  Input: s = "LVIII" Output: 58

      Example 3:  Input: s = "MCMXCIV" Output: 1994
      Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. **/


public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0, previous = 0;
        char[] c = s.toCharArray();
        for(char ch: c) {
            if(ch=='I') {
                result+=1;
                previous = 1;
            }else if(ch=='V') {
                if(previous<5) {
                    result-=2*previous;
                }
                result+=5;
                previous = 5;
            }else if(ch=='X') {
                if(previous<10) {
                    result-=2*previous;
                }
                result+=10;
                previous = 10;
            }else if(ch=='L') {
                if(previous<50) {
                    result-=2*previous;
                }
                result+=50;
                previous = 50;
            }else if(ch=='C') {
                if(previous<100) {
                    result-=2*previous;
                }
                result+=100;
                previous = 100;
            }else if(ch=='D') {
                if(previous<500) {
                    result-=2*previous;
                }
                result+=500;
                previous = 500;
            }else if(ch=='M') {
                if(previous<1000) {
                    result-=2*previous;
                }
                result+=1000;
                previous = 1000;
            }

        }
        return result;
    }

    public int romanToInteger(String s) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result=map.get(s.charAt(s.length()-1));
        for(int i=s.length()-1;i>0;i--)
        {
            if(map.get(s.charAt(i))<=map.get(s.charAt(i-1)))
            {
                result+=map.get(s.charAt(i-1));
            }
            else
            {
                result-=map.get(s.charAt(i-1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
        System.out.println(romanToInteger.romanToInteger("MCMXCIV"));
    }
}


