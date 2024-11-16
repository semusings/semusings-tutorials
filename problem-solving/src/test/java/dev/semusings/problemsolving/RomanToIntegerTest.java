package dev.semusings.problemsolving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

class RomanToIntegerTest {

// @formatter:off

  private static Stream<Arguments> provider() {
    return Stream.of(
        Arguments.of("III", 3),
        Arguments.of("LVIII", 58),
        Arguments.of("MCMXCIV", 1994),
        Arguments.of("XIV", 14),
        Arguments.of("XIV", 14),
        Arguments.of("CM", 900)
    );
  }
//@formatter:on

    @ParameterizedTest
    @MethodSource("provider")
    void test(String s, int expected) {
        Assertions.assertEquals(expected, new Solution1().romanToInt(s));
        Assertions.assertEquals(expected, new Solution2().romanToInt(s));
        Assertions.assertEquals(expected, new Solution3().romanToInt(s));
    }


    private static class Solution1 {

        public int romanToInt(String s) {
            int[] numeralsMap = new int[128];
            numeralsMap['I'] = 1;
            numeralsMap['V'] = 5;
            numeralsMap['X'] = 10;
            numeralsMap['L'] = 50;
            numeralsMap['C'] = 100;
            numeralsMap['D'] = 500;
            numeralsMap['M'] = 1000;

            int result = 0;
            int index = 0;

            while (index < s.length()) {
                char c = s.charAt(index);
                if (c == 'I') {
                    if (index + 1 < s.length()) {
                        char nc = s.charAt(index + 1);
                        if (nc == 'V' || nc == 'X') {
                            result += (numeralsMap[nc] - numeralsMap[c]);
                            index += 2;
                            continue;
                        }
                    }
                } else if (c == 'X') {
                    if (index + 1 < s.length()) {
                        char nc = s.charAt(index + 1);
                        if (nc == 'L' || nc == 'C') {
                            result += (numeralsMap[nc] - numeralsMap[c]);
                            index += 2;
                            continue;
                        }
                    }
                } else if (c == 'C') {
                    if (index + 1 < s.length()) {
                        char nc = s.charAt(index + 1);
                        if (nc == 'D' || nc == 'M') {
                            result += (numeralsMap[nc] - numeralsMap[c]);
                            index += 2;
                            continue;
                        }
                    }
                }
                result += numeralsMap[c];
                index += 1;
            }
            return result;
        }
    }

    private static class Solution2 {

        public int romanToInt(String s) {
            int[] numeralsMap = new int[128];
            numeralsMap['I'] = 1;
            numeralsMap['V'] = 5;
            numeralsMap['X'] = 10;
            numeralsMap['L'] = 50;
            numeralsMap['C'] = 100;
            numeralsMap['D'] = 500;
            numeralsMap['M'] = 1000;

            int length = s.length();
            int result = 0;
            int index = 0;

            char[][] specialCharsMap = new char[128][2];
            specialCharsMap['I'] = new char[]{'V', 'X'};
            specialCharsMap['X'] = new char[]{'L', 'C'};
            specialCharsMap['C'] = new char[]{'D', 'M'};

            while (index < length) {
                char c = s.charAt(index);
                char[] specialChars = specialCharsMap[c];
                if (specialChars != null) {
                    int nci = index + 1;
                    if (nci < length) {
                        char nc = s.charAt(nci);
                        if (nc == specialChars[0] || nc == specialChars[1]) {
                            result += (numeralsMap[nc] - numeralsMap[c]);
                            index += 2;
                            continue;
                        }
                    }
                }
                result += numeralsMap[c];
                index += 1;
            }
            return result;
        }
    }

    private static class Solution3 {

        public int romanToInt(String s) {
            Map<Character, Integer> numeralsMap = Map.of(
                    'I', 1,
                    'V', 5,
                    'X', 10,
                    'L', 50,
                    'C', 100,
                    'D', 500,
                    'M', 1000
            );

            int length = s.length();
            int result = 0;
            int index = 0;

            Map<Character, Character[]> specialCharsMap = Map.of(
                    'I', new Character[]{'V', 'X'},
                    'X', new Character[]{'L', 'C'},
                    'C', new Character[]{'D', 'M'}
            );

            while (index < length) {
                char c = s.charAt(index);
                Character[] specialChars = specialCharsMap.get(c);
                if (specialChars != null) {
                    int nci = index + 1;
                    if (nci < length) {
                        char nc = s.charAt(nci);
                        if (nc == specialChars[0] || nc == specialChars[1]) {
                            result += (numeralsMap.get(nc) - numeralsMap.get(c));
                            index += 2;
                            continue;
                        }
                    }
                }
                result += numeralsMap.get(c);
                index += 1;
            }
            return result;
        }
    }
}