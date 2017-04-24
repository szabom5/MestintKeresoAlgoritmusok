package hu.marianna.problema.HanoiTornyai;

import java.util.Arrays;
import hu.marianna.problema.Allapot;

public class HanoiAllapot implements Allapot {

  //a 3 korong pozicioja
  int[] a;

  public HanoiAllapot() {
    a = new int[3];
  }

  @Override
  public boolean celAllapot() {
    return a[0] == 2 && a[1] == 2 && a[2] == 2;
  }

  @Override
  public int heurisztika() {
    return 0;
  }

  @Override
  public String toString() {
    return Arrays.toString(a);
  }
}
