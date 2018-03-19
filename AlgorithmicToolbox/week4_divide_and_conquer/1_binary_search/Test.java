import java.util.*;
import java.io.*;

public class Test {
	static void test(int N, int M){
      int[] arr = generateGivenLengthArray(N, M);
      Arrays.sort(arr);
      int x = (int)Math.floor(Math.random()*M);
			// long result1 = LinearSearch.linearSearch(arr, x);
			long result2 = BinarySearch.binarySearch(arr, x);

      System.out.println(x + ":" + result2);
		}

    // Returns an Array of max length N, with max value of M
    public static int[] generateRandomLengthArray(int N, int M){
      int n = (int)Math.floor(Math.random()*N)+2;
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = (int)Math.floor(Math.random()*M);
      }
      // for (int i = 0; i < arr.length; i++) {
      //   System.out.print(arr[i] + " ");
      // }
      // System.out.println("");
      return arr;
    }

    // Returns an Array of length N, with max value of M
    public static int[] generateGivenLengthArray(int N, int M){
      int n = N;
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = (int)Math.floor(Math.random()*M);
      }
      // for (int i = 0; i < arr.length; i++) {
      //   System.out.print(arr[i] + " ");
      // }
      // System.out.println("");
      return arr;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
	    int a = scanner.nextInt();
	    int b = scanner.nextInt();
	    test(a, b);
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