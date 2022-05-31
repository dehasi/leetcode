package leetcode.easy;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task796_RotateString_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.rotateString("abcde", "cdeab")).isTrue();
    }

    @Test void test11() {
        assertThat(solution.rotateString("gcmbf", "fgcmb")).isTrue();
    }

    @Test void test111() {
        assertThat(solution.rotateString("abc", "cab")).isTrue();
    }

    @Test void test2() {
        assertThat(solution.shift(solution.hash("abcde"), 'a'))
            .isEqualTo(solution.hash("bcdea"));

        assertThat(solution.shift(solution.hash("bcdea"), 'b'))
            .isEqualTo(solution.hash("cdeab"));
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        final int x = 31, mod = 1_000_000_007;
        final int xInv = BigInteger.valueOf(x).modInverse(BigInteger.valueOf(mod)).intValue();

        long P = 1;

        public boolean rotateString(String s, String goal) {
            long hs = hash(s), hgoal = hash(goal);
            if (hs == hgoal && s.equals(goal)) return true;
            int n = s.length();

            for (int i = 0; i < n; ++i) {
                hs = shift(hs, s.charAt(i));
                if (hs == hgoal) {
                    if (goal.equals(s.substring(i + 1) + s.substring(0, i + 1))) return true;
                }
            }
            return false;
        }

        /*
        P = xxx
        hash = (a + bx + cxx) /  mod = h(abc)
        new hash = a + bx + cxx -a + aP = bx + cxx + axxx / mod
        now we need to divide by x, therefore multiply by 1/x
        as we work in Field|mod -> we has to use modular inverse for x => xInv
        then we get
        (( bx + cxx + axxx / mod ) * xInv) /mod = (b + cx + axx)/mod
         */
        long shift(long hash, char ch) {
            int c = ch - 'a';
            hash = (hash - c + c * P) % mod;
            hash *= xInv;
            hash %= mod;
            return hash;
        }

        long hash(String s) {
            long res = 0, pow = 1;
            for (char ch : s.toCharArray()) {
                int c = ch - 'a';
                res = (res + c * pow) % mod;
                pow = pow * x % mod;
            }
            P = pow;
            return res % mod;
        }
    }
}
