import java.util.*;

//Trying to only use primitive types
public class LcmBetter2 {
  private static void lcm(int a, int b) {
    int[] P = {2,3,5,7,11,13,17,19,23,29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};
    int[] A = new int[100];
    int[] B = new int[100];
    int count = 0;
    int divisor = 0;
    while (a > 1) {
      System.out.print(P[divisor] + ": ");
      while (a % P[divisor] == 0) {
        System.out.print(a + " ");
        a = a/P[divisor];
        A[count] = P[divisor];
        count++;
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
        B[count] = P[divisor];
        count++;
      }
      divisor++;
    }
    long ans = 1;
    for (int i = 0; i < A.length; i++) {
      ans *= A[i];
    }
    for (int i = 0; i < B.length; i++) {
      ans *= B[i];
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
