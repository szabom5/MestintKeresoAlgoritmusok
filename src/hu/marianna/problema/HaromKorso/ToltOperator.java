package hu.marianna.problema.HaromKorso;

import hu.marianna.problema.Allapot;
import hu.marianna.problema.Operator;

public class ToltOperator implements Operator{
  int i;

  int j;

  public ToltOperator(int i, int j) {
    this.i = i;
    this.j = j;
  }

  private int mozgatottFolyadek(int i, int j, Allapot allapot) {
    int[] a = ((KorsoAllapot)allapot).a;
    int[] h = { 5, 3, 2}; // a korsok kapacitasa

    return Math.min(a[i], h[j] - a[j]);
  }

  @Override
  public boolean alkalmazhato(Allapot allapot) {
    return mozgatottFolyadek(i, j, allapot) > 0;
  }

  @Override
  public Allapot alkalmaz(Allapot eredetiAllapot) {

    KorsoAllapot ujAllapot = new KorsoAllapot();
    int[] a = ((KorsoAllapot)eredetiAllapot).a;
    int[] b = ujAllapot.a;

    for (int l = 0; l < 3; l++) {
      if (l == j) {
        b[l] = a[l] + mozgatottFolyadek(i, j, eredetiAllapot);
      } else if (l == i) {
        b[l] = a[l] - mozgatottFolyadek(i, j, eredetiAllapot);
      } else {
        b[l] = a[l];
      }
    }

    return ujAllapot;
  }

}
