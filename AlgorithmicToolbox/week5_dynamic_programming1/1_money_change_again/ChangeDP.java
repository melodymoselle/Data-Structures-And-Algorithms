import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] coins = {1, 3, 4};
        double[] minCoins = new double[m+1];
        minCoins[0] = 0;
        for (int i = 1; i <= m; i++) {
          minCoins[i] = Double.POSITIVE_INFINITY;
          for (int c : coins) {
            if (i >= c) {
              double numCoins = minCoins[i - c] + 1;
              if (numCoins < minCoins[i]) {
                minCoins[i] = numCoins;
              }
            }
          }
        }
        return (int)minCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

