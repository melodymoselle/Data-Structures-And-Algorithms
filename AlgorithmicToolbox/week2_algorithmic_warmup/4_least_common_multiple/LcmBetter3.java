import java.util.*;

//
public class LcmBetter3 {
  private static void lcm(int a, int b) {
    int[] P = {2,3,5,7,11,13,17,19,23,29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};
    List<Integer> A = new ArrayList<Integer>();
    List<Integer> B = new ArrayList<Integer>();
    int count = 0;
    int divisor = 0;
    while (a > 1) {
      System.out.print(P[divisor] + ": ");
      while (a % P[divisor] == 0) {
        System.out.print(a + " ");
        a = a/P[divisor];
        A.add(P[divisor]);
      }
      divisor++;
    }
    count = 0;
    divisor = 0;
    while (b > 1) {
      System.out.print(P[divisor] + ": ");
      while (b % P[divisor] == 0) {
        System.out.print(b + " ");
        b = b/P[divisor];
        B.add(P[divisor]);
      }
      divisor++;
    }
    System.out.println(" ");
    long ans = 1;
    for (Integer p : A) {
      ans *= p;
      B.remove(p);
        System.out.print(ans + " ");
    }
    for (Integer p : B) {
      ans *= p;
        System.out.print(ans + " ");
    }
    return;
  }

  // private static int[] generatePrimes(int a){
  //   int[] P = new int[100];
  //   int root = (int)Math.sqrt(a);
  //   int n = 2;
  //   while (n < root) {
      
  //   }
  // }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    lcm(a, b);
  }
}
