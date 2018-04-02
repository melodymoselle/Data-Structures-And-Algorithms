import java.io.*;
import java.util.*;

public class Sorting3Way {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      int x = a[l];

      int m1 = l;
      int m2 = r;
      for (int i = l + 1; i <= m2; i++) {
          if (a[i] == x){
              m2--;
              int t = a[i];
              a[i] = a[m2];
              a[m2] = t;
              i--;
          }
          if (a[i] < x) {
              m1++;
              int t = a[i];
              a[i] = a[m1];
              a[m1] = t;
          }
      }
        a[l] = a[m1];
        a[m1] = a[m2];
        a[m2] = x;
        for (int i = m1, j = m2; j < a.length; i++, j++) {
          int t = a[j];
          a[j] = a[i];
          a[i] = t;
          m2 = i;
        }

      int[] m = {m1, m2};
      return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0]-1);
        randomizedQuickSort(a, m[1]+1, r);

        
        // int m = partition2(a, l, r);
        // randomizedQuickSort(a, l, m - 1);
        // randomizedQuickSort(a, m + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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

