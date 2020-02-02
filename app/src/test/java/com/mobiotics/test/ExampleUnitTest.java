package com.mobiotics.test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    public  void printRLE(String s)
    {
        for (int i = 0; i < s.length(); i++) {

            // Counting occurrences of s[i]
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            System.out.print(s.charAt(i) + "" + count);
        }

        System.out.println();
    }

    // Driver code
    @Test
    public  void check()
    {
        printRLE("Geee  EEKKKss");
        printRLE("ccccOddEEE");
        printELR("c4O1d2E3");
        printELR("G1e3 2E2K3s2");
    }

    public  void printELR(String s)
    {
        StringBuilder totalString= new StringBuilder();

        for(int i=0;i<s.length();i=i+2){
            char character=s.charAt(i);
            int totalCount=Integer.parseInt(String.valueOf(s.charAt(i+1)));
            int count=0;
            while (count<totalCount){
                totalString.append(character);
                count++;
            }
        }
        System.out.println(totalString);
    }
}