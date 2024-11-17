package dev.semusings.problemsolving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

class ValidParenthesesTest {

// @formatter:off

  private static Stream<Arguments> provider() {
    return Stream.of(
        Arguments.of("()", true),
        Arguments.of("()[]{}", true),
        Arguments.of("(]", false),
        Arguments.of("([])", true),
        Arguments.of("({{[([])]}})", true),
        Arguments.of("([{[([])]}})", false),
        Arguments.of("([{[([])])])", false)
    );
  }
//@formatter:on

    @ParameterizedTest
    @MethodSource("provider")
    void test(String s, boolean expected) {
        Assertions.assertEquals(expected, new Solution1().isValid(s));
    }


    private static class Solution1 {

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                }
                if (c == ')' || c == '}' || c == ']') {
                    Character lastChar = stack.pop();
                    if (c == ')' && lastChar != '(') {
                        return false;
                    }
                    if (c == '}' && lastChar != '{') {
                        return false;
                    }
                    if (c == ']' && lastChar != '[') {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}