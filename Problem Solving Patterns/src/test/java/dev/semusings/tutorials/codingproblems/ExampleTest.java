package dev.semusings.tutorials.codingproblems;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ExampleTest {

// @formatter:off

  private static Stream<Arguments> provider() {
    return Stream.of(
        Arguments.of("aab", "aba"),
        Arguments.of("aaab", "")
    );
  }
//@formatter:on

    @ParameterizedTest
    @MethodSource("provider")
    void test(String s, String expected) {
        Assertions.assertEquals(expected, new Solution1().solve(s));
    }


    private static class Solution1 {

        public String solve(String s) {
            return null;
        }
    }
}