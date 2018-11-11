package test.test01;


import java.util.Scanner;

public class Main {

    public static void getResult(int n, int m) {
        int min = n / 2;
        int max = 1;
        int temp = n / 2;
        if (max <= m) {
            for (int i = 1; i <= temp; i++) {
                max = max * i;
            }
        }

        System.out.println(min);
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s1 = scanner.next();
            String s2 = scanner.next();

            getResult(Integer.parseInt(s1), Integer.parseInt(s2));
        }
    }
}
