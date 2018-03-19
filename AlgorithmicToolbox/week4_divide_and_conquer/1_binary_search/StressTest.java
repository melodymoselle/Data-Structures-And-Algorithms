import java.util.*;
import java.io.*;

public class StressTest {
	static void stressTest(int N, int M){
		while (true) {
      int[] arr = generateArray(N, M);
      int x = (int)Math.floor(Math.random()*M);
			long result1 = LinearSearch.linearSearch(arr, x);
			long result2 = BinarySearch.binarySearch(arr, 0, arr.length-1, x);
			if (result1 == result2) {
				System.out.println("OK: " + x + " : " + result1 + " : " + result2);
			} else {
				System.out.println("Wrong answer: " + x + " : " + result1 + " : " + result2);
				return;
			}
		}
	}

    // Returns an Array of length N, with max value of M
    public static int[] generateArray(int N, int M){
      int n = (int)Math.floor(Math.random()*N)+2;
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = (int)Math.floor(Math.random()*M);
      }
      Arrays.sort(arr);
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println("");
      return arr;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
	    int a = scanner.nextInt();
	    int b = scanner.nextInt();
	    stressTest(a, b);
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