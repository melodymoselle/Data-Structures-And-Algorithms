import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int[] values = {10, 5, 1};
        int n = 0;
        for (int v : values) {
          if (m == 0) {
            return n;
          }
          while (m >= v) {
            m -= v;
            n++;
            // System.out.print(v + " ");
          }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

