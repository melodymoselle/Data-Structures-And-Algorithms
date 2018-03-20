import java.io.*;
import java.util.*;

public class MultPolyNaive {

  private static int[] multPoly(int n, int[] a, int[] b){
    int[][] pair = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        pair[i][j] = a[i] * b[j];
      }
    }
    int[] product = new int[2*n-1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        product[i+j] += pair[i][j];
      }
    }
    return product;
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
      int[] c = new int[2*n-1];
      c = multPoly(n, a, b);
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