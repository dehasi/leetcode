package leetcode.medium;

import java.util.Objects;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1041_RobotBoundedInCircle_Test {

    private final Solution solution = new Solution();

    @Test void test1() {
        assertThat(solution.isRobotBounded("GGLLGG")).isTrue();
    }

    @Test void test2() {
        assertThat(solution.isRobotBounded("GG")).isFalse();
    }

    @Test void test3() {
        assertThat(solution.isRobotBounded("GL")).isTrue();
    }

    @Test void test4() {
        assertThat(solution.isRobotBounded("GLGLGGLGL")).isFalse();
    }

    // [_] Input boundaries:
    // [_] Edge cases:
    // [_] Complexity (time, memory):
    class Solution {
        public boolean isRobotBounded(String instructions) {
            Point[] direction = new Point[] {
                new Point(0, 1), // North
                new Point(1, 0), //  East
                new Point(0, -1),// South
                new Point(-1, 0) // West
            };
            int x = 0, y = 0, dir = 0; // North
            for (int i = 0; i < instructions.length(); ++i) {
                switch (instructions.charAt(i)) {
                    case 'G': {
                        x += direction[dir].x;
                        y += direction[dir].y;
                        break;
                    }
                    case 'L': {
                        dir = (dir - 1) < 0 ? direction.length - 1 : (dir - 1) % direction.length;
                        break;
                    }
                    case 'R': {
                        dir = (dir + 1) % direction.length;
                        break;
                    }
                }
            }
            return (x == 0 && y == 0) || dir != 0;
        }

        class Point {
            int x, y;

            Point(int x, int y) {
                this.x = x; this.y = y;
            }

            @Override public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Point point = (Point)o;
                return x == point.x && y == point.y;
            }

            @Override public int hashCode() {
                return Objects.hash(x, y);
            }

            @Override
            public String toString() {
                return "(" + x + ", " + y + ")";
            }
        }
    }
}