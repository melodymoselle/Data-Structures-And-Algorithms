import java.util.Scanner;

public class FibonacciList {
  static long calc_fib(int n) {
    if (n <= 1) {
      return n;
    } else {
      long[] F = new long[n+1];
      F[0] = 0;
      F[1] = 1;
      for (int i = 2; i <= n; i++) {
        F[i] = F[i-1] + F[i-2];
      }
      // for (int i = 0; i < F.length; i++) {
      //   System.out.print(F[i] + " ");
      // }
      return F[n];
    }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
