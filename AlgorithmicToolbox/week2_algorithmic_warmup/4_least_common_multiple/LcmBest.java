import java.util.*;

//
public class LcmBest {

  private static long lcm(int a, int b) {
    return ((long)a*(long)b)/(long)gcd(a,b);
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a%b);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
