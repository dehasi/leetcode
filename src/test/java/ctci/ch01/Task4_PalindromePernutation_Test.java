package ctci.ch01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4_PalindromePernutation_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.isPalindromePermutation("Taco cat")).isTrue();
    }

    @Test void test2() {
        assertThat(solution.isPalindromePermutation("Taco bat")).isFalse();
    }

    @Test void test3() {
        assertThat(solution.isPalindromePermutation("Tac cat")).isTrue();
    }

    // [_] Input boundaries: letters + white spaces.
    // [_] Edge cases:
    // [_] Complexity (time, memory): O(s.len), O(26)
    class Solution {

        boolean isPalindromePermutation(String s) {
            s = s.toLowerCase();
            int[] letters = new int[26];
            int lettercount = 0;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (ch == ' ') continue;
                ++letters[ch - 'a'];
                ++lettercount;
            }
            int odd_count = 0;
            for (int letter : letters)
                if (letter % 2 == 1) ++odd_count;
            if (odd_count > 1) return false;
            return odd_count == lettercount % 2;
        }
    }
}