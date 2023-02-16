package calculator;

import java.util.TreeMap;

public class RomanToArabian {
    static TreeMap<Character, Integer> romanMap = new TreeMap<>();
    static TreeMap<Integer, String> arabianMap = new TreeMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        arabianMap.put(1000, "M");
        arabianMap.put(900, "CM");
        arabianMap.put(500, "D");
        arabianMap.put(400, "CD");
        arabianMap.put(100, "C");
        arabianMap.put(90, "XC");
        arabianMap.put(50, "L");
        arabianMap.put(40, "XL");
        arabianMap.put(10,"X");
        arabianMap.put(9, "IX");
        arabianMap.put(5,"V");
        arabianMap.put(4,"IV");
        arabianMap.put(1, "I");
    }

    public static boolean isRoman(String value) {
        return romanMap.containsKey(value.charAt(0));
    }

    public static int romanToInt(String s) {
        int res = 0;
        int pr = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = romanMap.get(s.charAt(i));
            if (cur < pr) {
                res -= cur;
            } else {
                res += cur;
            }
            pr = cur;
        }
        return res;
    }

    public static String intToRoman(int number) {
        StringBuilder roman = new StringBuilder();
        int arabian;
        do {
            arabian = arabianMap.floorKey(number);
            roman.append(arabianMap.get(arabian));
            number -= arabian;
        }while (number != 0);
        return roman.toString();
    }
}
