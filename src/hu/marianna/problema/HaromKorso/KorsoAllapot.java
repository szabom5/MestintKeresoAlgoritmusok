package hu.marianna.problema.HaromKorso;

import hu.marianna.problema.Allapot;

public class KorsoAllapot implements Allapot {

  int a[] = new int[3];

  public KorsoAllapot() {
    a[0] = 5;
    a[1] = 0;
    a[2] = 0;
  }

  @Override
  public boolean celAllapot() {
    return a[0] == 4;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("(").append(a[0]);
    sb.append(",").append(a[1]);
    sb.append(",").append(a[2]).append(")");
    return sb.toString();
  }

  @Override
  public boolean equals(Object arg0) {
    if (arg0 == null || !(arg0 instanceof KorsoAllapot)) {
      return false;
    }

    int b[] = ((KorsoAllapot) arg0).a;
    for (int i = 0; i < 3; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    return a[0] * 100 + a[1] * 10 + a[2];
  }

  public int heurisztika() {
    if (celAllapot()) {
      return 0;
    }

    return 4 - (a[0] > 0 ? 1 : 0) - (a[1] > 0 ? 1 : 0) - (a[2] > 0 ? 1 : 0);
  }

}

