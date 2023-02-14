package calculator;

import java.util.HashMap;

public class RomanToArabian {
    HashMap<Character, Integer> map = new HashMap<>();

    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;
        int pr = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = map.get(s.charAt(i));
            if (cur < pr) {
                res -= cur;
            } else {
                res += cur;
            }
            pr = cur;
        }
        return res;
    }

}
