package dev.semusings.tutorials.leetcode.video1;

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
        Arguments.of("MCMXCIV", 1994)
    );
  }
//@formatter:on

    @ParameterizedTest
    @MethodSource("provider")
    void test(String s, int expected) {
        Assertions.assertEquals(expected, new Solution1().solve(s));
    }


    private static class Solution1 {

        public int solve(String s) {
            Map<Character, Integer> map = Map.of(
                    'I', 1,
                    'V', 5,
                    'X', 10,
                    'L', 50,
                    'C', 100,
                    'D', 500,
                    'M', 1000
            );
            int rs = 0;

            for (int i = 0 ; i < s.length();  ) {
                char c = s.charAt(i);
                if ((c == 'I' || c == 'X' || c == 'C') && i < s.length() - 1) {
                    char nc = s.charAt( i + 1);
                    if (c == 'I' && (nc == 'V' || nc == 'X')) {
                        rs = rs + (map.get(nc) - map.get(c));
                        i = i + 2;
                        continue;
                    } else if (c == 'X' && (nc == 'L' || nc == 'C')) {
                        rs = rs + (map.get(nc) - map.get(c));
                        i = i + 2;
                        continue;
                    } else if (c == 'C' && (nc == 'D' || nc == 'M')) {
                        rs = rs + (map.get(nc) - map.get(c));
                        i = i + 2;
                        continue;
                    }
                }
                rs = rs + map.get(c);
                i++;
            }
            return rs;
        }
    }
}