import java.util.*;

public class LcmBetter {
  private static long lcm(int a, int b) {
    int[] A = new int[100000];
    int[] B = new int[100000];
    boolean found = false;
    int count = 2;
    int ans = 0;
    while (!found) {
      A[count] = a*count;
      B[count] = b*count;
      for (int i = 2; i <= count; i++) {
        for (int j = 2; j <= count; j++) {
          if (A[i] == B[j]) {
            found = true;
            ans = A[i];
          }
        }
      }
      count++;
    }
    return ans;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
