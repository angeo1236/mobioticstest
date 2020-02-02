package com.mobiotics.test;

import org.junit.Test;

public class TestClass {
    public void encodeText(String s) {
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
    public void check() {
        encodeText("Aaangeeoo");
        decodeText1("a10b1c3");
    }

    public void decodeText(String s) {
        StringBuilder totalString = new StringBuilder();

        for (int i = 0; i < s.length(); i = i + 2) {
            char character = s.charAt(i);
            int totalCount = Integer.parseInt(String.valueOf(s.charAt(i + 1)));
            int count = 0;
            while (count < totalCount) {
                totalString.append(character);
                count++;
            }
        }
        System.out.println(totalString);
    }

    public void decodeText1(String s) {
        StringBuilder totalString = new StringBuilder();
        int totalcount = s.length();
        int i = 0;
        while (i < totalcount) {
            int count = 0;
            String countString = "";
            String charFound = String.valueOf(s.charAt(i));
            i++;
            System.out.println(charFound);
            System.out.println(i);
            while (i<totalcount&&Character.isDigit(s.charAt(i))) {
                countString += s.charAt(i);

                    i++;

            }

            count = Integer.parseInt(countString);
            System.out.println(count);
            for (int j = 0; j < count; j++) {
                totalString.append(charFound);
            }
            System.out.println(totalString);
        }
        System.out.println(totalString);

    }
}
