import java.util.*;
import java.io.*;
import java.lang.*;

public class MaxPairwiseProductStressTest {
	static void stressTest(int N, int M){
		while (true) {
			int n = (int)Math.floor(Math.random()*N)+2;
			int[] A = new int[n];
			for (int i = 0; i < n; i++) {
				A[i] = (int)Math.floor(Math.random()*M);
			}
			for (int i = 0; i < A.length; i++) {
				System.out.print(A[i] + " ");
			}
			System.out.println("");
			long result1 = MaxPairwiseProductFast.getMaxPairwiseProduct(A);
			long result2 = MaxPairwiseProduct.getMaxPairwiseProduct(A);
			if (result1 == result2) {
				System.out.println("OK");
			} else {
				System.out.println("Wrong answer: " + result1 + " : " + result2);
				return;
			}
		}
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