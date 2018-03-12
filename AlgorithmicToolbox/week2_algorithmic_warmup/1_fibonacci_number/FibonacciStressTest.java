import java.util.Scanner;

public class FibonacciStressTest{
	private static void stressTest(int N){
		while (true) {
			int n = (int)Math.floor(Math.random()*N)+1;
			System.out.println(n);
			long resultList = FibonacciList.calc_fib(n);
			long resultRecur = FibonacciRecursive.calc_fib(n);
			if (resultList == resultRecur) {
				System.out.println("OK");
			} else {
				System.out.println("Wrong answer: " + resultList + " : " + resultRecur);
				return;
			}
		}
	}

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    stressTest(n);
  }
}