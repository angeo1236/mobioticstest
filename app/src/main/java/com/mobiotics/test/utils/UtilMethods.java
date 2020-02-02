package com.mobiotics.test.utils;

public class UtilMethods {

    public static String encryptText(String s)
    {
        StringBuilder totalString= new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            // Counting occurrences of s[i]
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            totalString.append(s.charAt(i)).append(count);
        }

        return totalString.toString();
    }



    public static String decryptText(String s) throws Exception {
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
        return totalString.toString();

    }

}
