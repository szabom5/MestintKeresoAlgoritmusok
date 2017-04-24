package hu.marianna.problema.HaromKorso;

import hu.marianna.problema.Allapot;

public class KorsoAllapot implements Allapot {

  int a[] = new int[4];

	/*
        boolean kenyszerfeltetel() {
		return a[1]+a[2]+a[3] == 5;
	}
	*/

  public KorsoAllapot() {
    a[1] = 5;
    a[2] = 0;
    a[3] = 0;
  }

  @Override
  public boolean celAllapot() {
    return a[1] == 4;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer(7);
    sb.append("(").append(a[1]);
    sb.append(",").append(a[2]);
    sb.append(",").append(a[3]).append(")");
    return sb.toString();
  }

  @Override
  public boolean equals(Object arg0) {
    if (arg0 == null || !(arg0 instanceof KorsoAllapot)) {
      return false;
    }

    int b[] = ((KorsoAllapot) arg0).a;
    for (int i = 1; i <= 3; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    return a[1] * 100 + a[2] * 10 + a[3];
  }

  public int heurisztika() {
    if (celAllapot()) {
      return 0;
    }

    return 40000 - (a[1] > 0 ? 1 : 0) - (a[2] > 0 ? 1 : 0) - (a[3] > 0 ? 1 : 0);
  }


}

