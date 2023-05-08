package nium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class Task2Test {

    @Test
    void name() {
        Assertions.assertThat(uniqueSubstringPartition("codingisfun")).isEqualTo(2);
        Assertions.assertThat(uniqueSubstringPartition("111222333")).isEqualTo(7);
    }

    static int uniqueSubstringPartition(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> set = new HashSet<>();

        int result = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                ++result;
                set.clear();
            }
            set.add(ch);
        }

        return result;
    }
}
