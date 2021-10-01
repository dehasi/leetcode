package algs4Part1.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String winner = "";
        int t = 1;
        while (!StdIn.isEmpty()) {
            String current = StdIn.readString();
            if (StdRandom.bernoulli(1. / t))
                winner = current;
            ++t;
        }
        System.out.println(winner);
    }
}
