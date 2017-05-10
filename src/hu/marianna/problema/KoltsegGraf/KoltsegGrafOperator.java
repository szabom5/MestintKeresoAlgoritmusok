package hu.marianna.problema.KoltsegGraf;

import hu.marianna.problema.Allapot;
import hu.marianna.problema.Operator;

public class KoltsegGrafOperator implements Operator {

  public KoltsegGrafAllapot honnan;

  public KoltsegGrafAllapot hova;

  public int koltseg;

  public KoltsegGrafOperator(KoltsegGrafAllapot honnan,
                             KoltsegGrafAllapot hova, int koltseg) {
    this.honnan = honnan;
    this.hova = hova;
    this.koltseg = koltseg;
  }

  @Override
  public int koltseg() {
    return koltseg;
  }

  @Override
  public boolean alkalmazhato(Allapot allapot) {
    return honnan.equals(allapot);
  }

  @Override
  public Allapot alkalmaz(Allapot eredetiAllapot) {
    return hova;
  }
}
