package tasks.codeforces.round197;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://codeforces.com/problemset/problem/339/A
 * Done
 */
public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String result = Arrays.stream(s.split("\\+"))
                .mapToLong(Long::parseLong)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("+"));

        System.out.println(result);
    }
}
