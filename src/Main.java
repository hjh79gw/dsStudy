//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    // 자릿수
        String s = sc.next();    // 붙어있는 숫자 문자열 (nextInt() 아님!!)
        int sum = 0;
        for (int i = 0; i < n; i++) sum += s.charAt(i) - '0';
        System.out.print(sum);
    }
}