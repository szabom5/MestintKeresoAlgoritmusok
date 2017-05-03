package hu.marianna.problema.HanoiTornyai;

import hu.marianna.problema.Allapot;
import hu.marianna.problema.Operator;

public class HanoiOperator implements Operator {

  //korong eredeti pozicioja
  int i;

  //korong uj pozicioja
  int j;

  public HanoiOperator(int i, int j) {
    this.i = i;
    this.j = j;
  }

  @Override
  public int koltseg() {
    return 1;
  }

  @Override
  public boolean alkalmazhato(Allapot allapot) {
    int[] a = ((HanoiAllapot) allapot).a;

    int kiinduloToronyLegkisebbKorongja = Integer.MAX_VALUE;
    int celToronyLegkisebbKorongja = Integer.MAX_VALUE;

    //korongokon jarunk vegig
    for (int k = 0; k < 3; ++k) {
      if (a[k] == i && k < kiinduloToronyLegkisebbKorongja) {
        kiinduloToronyLegkisebbKorongja = k;
      }
      if (a[k] == j && k < celToronyLegkisebbKorongja) {
        celToronyLegkisebbKorongja = k;
      }
    }

    return kiinduloToronyLegkisebbKorongja < celToronyLegkisebbKorongja;

  }

  @Override
  public Allapot alkalmaz(Allapot eredetiAllapot) {

    HanoiAllapot ujAllapot = new HanoiAllapot();
    int[] a = ((HanoiAllapot) eredetiAllapot).a;
    int[] b = ujAllapot.a;

    int kiinduloToronyLegkisebbKorongja = Integer.MAX_VALUE;

    for (int k = 0; k < 3; ++k) {
      if (a[k] == i && k < kiinduloToronyLegkisebbKorongja) {
        kiinduloToronyLegkisebbKorongja = k;
      }
    }

    for (int l = 0; l < 3; l++) {
      if (l == kiinduloToronyLegkisebbKorongja) {
        b[l] = j;
      } else {
        b[l] = a[l];
      }
    }

    return ujAllapot;
  }
}
