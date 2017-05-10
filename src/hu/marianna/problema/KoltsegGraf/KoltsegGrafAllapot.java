package hu.marianna.problema.KoltsegGraf;

import java.util.ArrayList;
import java.util.List;
import hu.marianna.problema.Allapot;

public class KoltsegGrafAllapot implements Allapot {

  public int a;

  public KoltsegGrafAllapot(int a) {
    this.a = a;
  }

  @Override
  public boolean celAllapot() {
    return a == 3 || a == 7;
  }

  @Override
  public int heurisztika() {
    int[] list = new int[]{5,5,2,0,1,1,Integer.MAX_VALUE,0};

    return list[a];
  }

  @Override
  public String toString() {
    return "" + a;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    KoltsegGrafAllapot that = (KoltsegGrafAllapot) o;

    return a == that.a;

  }

  @Override
  public int hashCode() {
    return a;
  }
}
