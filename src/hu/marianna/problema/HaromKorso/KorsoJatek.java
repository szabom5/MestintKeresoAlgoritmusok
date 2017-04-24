package hu.marianna.problema.HaromKorso;

import java.util.ArrayList;
import java.util.List;
import hu.marianna.problema.Allapot;
import hu.marianna.problema.Jatek;
import hu.marianna.problema.Operator;

public class KorsoJatek implements Jatek {

  @Override
  public List<Operator> operatorok() {
    List operatorok = new ArrayList();

    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        if (i != j) {
          operatorok.add(new ToltOperator(i, j));
        }
      }
    }

    return operatorok;
  }

  @Override
  public Allapot kezdoAllapot() {
    return new KorsoAllapot();
  }
}
