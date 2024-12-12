/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1. test
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        if (num == null || num.isEmpty()) {
            return ans;
        }
        int indexb = num.lastIndexOf('b');
        if (!num.contains("b") || indexb == num.length() - 1 || indexb == 0) {
            return ans;
        }
        String[] parts = num.split("b");
        if (parts.length != 2) {
            return ans;
        }
        String numberpart = parts[0];
        String basepart = parts[1];
        char[] charbase = basepart.toCharArray();
        char[] eachnumber = numberpart.toCharArray();
        int number;
        String numstr = "";
        for (int i = 0; i < numberpart.length(); i++) {
            if (eachnumber[i] >= '0' && eachnumber[i] <= '9') {
                if (eachnumber[i] < charbase[0]) {
                    number   = eachnumber[i] - '0';
                    numstr = numstr + number;
                }
                else return ans;
            } else if (eachnumber[i] >= 'A' && eachnumber[i] <= 'G') {
                if (eachnumber[i] < charbase[0]) {
                    numstr = numstr + eachnumber[i];
                }
                else return ans;
            }
            else return ans;
        }

        int base;
        if (basepart.length() == 1) {
            char basechar = Character.toUpperCase(basepart.charAt(0));
            if (basechar >= '2' && basechar <= '9') {
                base = basechar - '0';
            } else if (basechar >= 'A' && basechar <= 'G') {
                base = basechar - 'A' + 10;
            } else {
                return ans;
            }
        } else {
            return ans;
        }
        return Integer.parseInt(numstr,base);



    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        // add your code here
        if (a == null || a.isEmpty()) {
            ans = false;
            return ans;
        }
        if (!a.contains("b")){
            char[] charnum = a.toCharArray();
            for (int i = 0; i < charnum.length; i++) {
                if (charnum[i] >= '0' && charnum[i] <= '9') {
                     ans = true;
                }
                else return false;
            }
            return ans;
        }
        int indexb = a.lastIndexOf('b');
        if ( indexb == a.length() - 1 || indexb == 0) {
            ans = false;
            return ans;
        }
        String numberpart = a.substring(0, indexb);
        String basepart = a.substring(indexb+1);
        char basechar = basepart.charAt(0);
        char[] eachnumber = numberpart.toCharArray();
        for (int i = 0; i < eachnumber.length; i++) {
            if (eachnumber[i] >= '0' && eachnumber[i] <= '9') {
                if (eachnumber[i] < basechar) {
                    ans = true;
                }
                else {
                    ans = false;
                    return ans;
                }
            }
            else if (eachnumber[i] >= 'A' && eachnumber[i] <= 'G') {
                if (eachnumber[i] < basechar) {
                    ans = true;
                }
                else {
                    ans = false;
                    return ans;
                }
            }
            else {
                ans = false;
                return ans;
            }
        }
        ////////////////////
        return ans;
    }


    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        // add your code here
        String ans = "";
        if(num< 0 || base < 2 || base > 16) {
            return ans;
        }
        if(num == 0){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        String digits = "0123456789ABCDEF";

        while (num > 0) {
            int remainder = num % base;
            result.append(digits.charAt(remainder));
            num /= base;
        }
         result.reverse().toString();
        String fullnumber = result + "b" + base;
        return fullnumber;


    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here
        if(number2Int(n1) != number2Int(n2)){
            ans = false;

        }
        return ans;
        ////////////////////
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = -1;
        // add your code here
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > max && value != -1) {
                max = value;
                ans = i;
            }
        }

        //////////////////
        return ans;
    }
}
