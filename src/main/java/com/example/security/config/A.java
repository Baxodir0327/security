package com.example.security.config;

public class A {
        public static void main(String[] args) {
            int limit = 1762;

            for (int i =1; i < limit; i++) {
                String result = generateSequence(i);
                System.out.println(result);
            }
        }

        public static String generateSequence(int n) {
            StringBuilder sequence = new StringBuilder("1");

            while (n > 0) {
                int remainder = (n-1) % 26;
                char character = (char) ('A' + remainder);
                sequence.insert(1, character);
                n = (n-1) / 26;
            }

            return sequence.toString();
        }


}
