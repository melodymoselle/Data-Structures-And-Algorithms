import java.util.*;
import java.io.*;

public class RandomQuicksort {
    private static int[] sort(int[] a, int left, int right){
      int mid;
      if (left < right) {
        mid = partition(a, left, right);
        sort(a, left, mid-1);
        sort(a, mid+1, right);
      }
      return a;
    }

    private static int partition(int[] a, int left, int right){
      int x = a[right];
      int i = left-1;
      int temp;
      for (int j = left; j<right; j++) {
        if (a[j]<=x) {
          i++;
          temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
      temp = a[i+1];
      a[i+1] = a[right];
      a[right] = temp;
      return i+1;
    }

    private static int randomPartition(int[] a, int left, int right){
      int i = (int)(Math.random()*right)+left;
      int temp = a[right];
      a[right] = a[i];
      a[i] = temp;
      return partition(a, left, right);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        a = sort(a, 0, n-1);
        for (int i : a) {
          System.out.print(i + " ");
        }
          System.out.println();
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