import java.util.*;

public class LargestNumberBetter {
    private static String largestNumber(String[] a) {
        List<String> Digits = new ArrayList<String>(Arrays.asList(a));
        String result = "";
        while (!Digits.isEmpty()) {
          String maxDigit = "0";
          for (String digit: Digits) {
            if (isGreaterOrEqual(digit, maxDigit)) {
              maxDigit = digit;
            }
          }
          result += maxDigit;
          Digits.remove(maxDigit);
        }
        return result;
    }

    private static boolean isGreaterOrEqual(String digit, String maxDigit){
      if (Double.parseDouble(digit+maxDigit)>=Double.parseDouble(maxDigit+digit)) {
        return true;
      } else {
        return false;
      }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

