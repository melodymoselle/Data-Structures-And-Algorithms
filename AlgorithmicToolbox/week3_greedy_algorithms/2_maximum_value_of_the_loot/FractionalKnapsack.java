import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        int n = values.length;
        double sackValue = 0;
        double[] valueRatios = new double[n];
        for (int i = 0; i < n; i++) {
          valueRatios[i] = (double)values[i]/(double)weights[i];
          // System.out.print(valueRatios[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < n; i++) {
          int maxValueIndex = getMaxValueIndex(valueRatios);
          int amount = Math.min(capacity, weights[maxValueIndex]);
          sackValue += amount*valueRatios[maxValueIndex];
          capacity -= amount;
          valueRatios[maxValueIndex] = 0;
        }

        return sackValue;
    }

    private static int getMaxValueIndex(double[] valueRatios){
        int maxValueIndex = 0;
        for (int i = 1; i < valueRatios.length; i++) {
          if (valueRatios[i] > valueRatios[maxValueIndex]) {
            maxValueIndex = i;
          }
        }
        return maxValueIndex;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
