package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class IntAsArrayIncrement {

  @EpiTest(testDataFile = "int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> a) {

    if (a.size() <= 0) {
      return a;
    }

    int n = a.size() - 1;
    a.set(n, a.get(n) + 1);
    for (int i = n; i > 0 && a.get(i) == 10; i--) {
      a.set(i, 0);
      a.set(i-1, a.get(i-1)+1);
    }

    if(a.get(0) == 10) {
      a.set(0,1);
      a.add(0);
    }

//    int n = a.size() - 1;
//    a.set(n, a.get(n) + 1);
//    for (int i = n; i > 0 && a.get(i) == 10; --i) {
//      a.set(i, 0);
//      a.set(i - 1, a.get(i - 1) + 1);
//    }
//    if (a.get(0) == 10) {
//      // There is a carry-out, so we need one more digit to store the result.
//      // A slick way to do this is to append a 0 at the end of the array,
//      // and update the first entry to 1.
//      a.set(0, 1);
//      a.add(0);
//    }
    return a;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
