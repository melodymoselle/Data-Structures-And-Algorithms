import java.io.*;
import java.util.*;

public class MultPolyKaratsuba {

  private static List<Integer> multPoly(List<Integer> A, List<Integer> B){
    int n = A.length;
    int m = 2*n-1;
    // int[] result = new int[n];
    List<Integer> result = new ArrayList<Integer>();
    if (n == 1) {
      result.set(0, A.get(0) * B.get(0));
      return result;
    }
    // List<Integer> A1 = new ArrayList<Integer>(Arrays.asList(Arrays.copyOfRange(A, 0, n/2)));
    List<Integer> A1 = new ArrayList<Integer>(A.subList(0, n/2));
    List<Integer> A2 = new ArrayList<Integer>(A.subList(A, n/2, n+1)));
    List<Integer> B1 = new ArrayList<Integer>(B.subList(B, 0, n/2)));
    List<Integer> B2 = new ArrayList<Integer>(B.subList(B, n/2, n+1)));

    List<Integer> P1 = multPoly(A1, B1);
    List<Integer> P2 = multPoly(A2, B2);
    List<Integer> P3 = multPoly((A1.addAll(A2))+(B1.addAll(B2))-P1-P2);

    result.addAll(P1);
    result.addAll(P3);
    result.addAll(P2);

    return result;
  }

  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    List<Integer> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        a.set(i, scanner.nextInt());
    }
    List<Integer> b = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      b.set(i, scanner.nextInt());
    }
    List<Integer> c = new ArrayList<>();
    c = multPoly(a, b);
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