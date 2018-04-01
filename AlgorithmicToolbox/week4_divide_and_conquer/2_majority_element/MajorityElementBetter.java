import java.util.*;
import java.io.*;

public class MajorityElementBetter {
    private static int getMajorityElement(int[] a) {
      int n = a.length;
      // System.out.println(n);
      if (n == 1) {
        return a[0];
      }
      if (n < 3) {
        if (a[0]==a[1]) {
          return a[0];
        } else {
          return -1;
        }
      }
      int left = getMajorityElement(Arrays.copyOfRange(a, 0, n/2));
      int right = getMajorityElement(Arrays.copyOfRange(a, n/2, n));
      if (left == right) {
        return left;
      }
      int countL = 0; 
      int countR = 0;
      for (int i : a) {
        if (i == left) {
          countL++;
        }
        if (i == right) {
          countR++;
        }
      }
      if (countL>n/2) {
        return left;
      }
      if (countR>n/2) {
        return right;
      }
      return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // System.out.println(getMajorityElement(a));
        if (getMajorityElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
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

