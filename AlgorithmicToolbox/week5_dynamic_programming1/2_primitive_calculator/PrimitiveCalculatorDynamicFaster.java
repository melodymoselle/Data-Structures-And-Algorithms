import java.util.*;

public class PrimitiveCalculatorDynamicFaster {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int[] counts = new int[n+1];

        //Calculate num of operations for each num up to n
        for (int i=1; i<counts.length; i++) {
          counts[i] = counts[i-1] + 1;
          if (i % 3 == 0) {
            counts[i] = Math.min(1+counts[i/3], counts[i]);
          } else if (i % 2 == 0) {
            counts[i] = Math.min(1 + counts[i/2], counts[i]);
          }
        }

        //Generate sequence
        for (int i = n; i > 1; ) {
          sequence.add(i);
          if (counts[i-1] == counts[i]-1) {
            i -= 1;
          } else if ((i%2 == 0) && (counts[i/2] == counts[i]-1)) {
            i /= 2;
          } else if ((i%3 == 0) && (counts[i/3] == counts[i]-1)) {
            i /= 3;
          }
        }
        sequence.add(1);

        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

