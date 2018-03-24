import java.io.*;
import java.util.*;

public class MultPolyNaiveDAC {

  private static int[] multPoly(int n, int[] A, int[] B, int a, int b){
    int[] result = new int[2*n-2];
    if (n == 1) {
      result[0] = A[a] * B[b];
      return result;
    }
    for (int i = 0; i <= n-2; i++) {
      result[i] = multPoly(n/2, A, B, a, b)[0];
    }
    for (int i = n; i <= 2*n-2; i++) {
      result[i] = multPoly(n/2, A, B, a+n/2, b+n/2)[0];
    }
    int D0E1 = multPoly(n/2, A, B, a, b+n/2)[0];
    int D1E1 = multPoly(n/2, A, B, a+n/2, b)[0];
    for (int i = n/2; i <= (n+n/2-2); i++) {
      result[i] += D0E1 * D1E1;
    }
    return result;
  }

  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
        a[i] = scanner.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = scanner.nextInt();
    }
    int[] c = new int[2*n-2];
    c = multPoly(n, a, b, 0, 0);
    for (int num : c) {
      System.out.print(num + " ");
    }
    System.out.println("");
  }
  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
        try {
            br = new BufferedReader(new InputStreamReader(stream));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
  }
}