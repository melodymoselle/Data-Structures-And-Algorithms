import java.util.*;

public class PrimitiveCalculatorDynamic {
    private static List<Integer> optimal_sequence(int n) {
        List<List<Integer>> sequence = new ArrayList<List<Integer>>();
        sequence.add(new ArrayList<Integer>());
        sequence.add(new ArrayList<Integer>(Arrays.asList(1)));
        sequence.add(new ArrayList<Integer>(Arrays.asList(1,2)));
        sequence.add(new ArrayList<Integer>(Arrays.asList(1,3)));
        for (int i = 4; i <= n; i++) {
          List<Integer>  temp = new ArrayList<Integer>();
          temp.add(i);
          if (i%3 == 0) {
            temp.addAll(0, sequence.get(i/3));
          } else if (i%2 == 0) {
            temp.addAll(0, sequence.get(i/2));
          } else {
            temp.addAll(0, sequence.get(i-1));
          }
          sequence.add(temp);
        }
        return sequence.get(n);
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

