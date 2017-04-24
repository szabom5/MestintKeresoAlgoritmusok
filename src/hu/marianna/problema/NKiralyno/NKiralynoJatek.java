package hu.marianna.problema.NKiralyno;

import java.util.ArrayList;
import java.util.List;
import hu.marianna.problema.Allapot;
import hu.marianna.problema.Jatek;
import hu.marianna.problema.Operator;

public class NKiralynoJatek implements Jatek {
  @Override
  public List<Operator> operatorok() {
    List operatorok = new ArrayList();
    int N = KiralynoAllapot.N;

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        operatorok.add(new KiralynoOperator(i, j));
      }
    }

    return operatorok;
  }

  @Override
  public Allapot kezdoAllapot() {
    return new KiralynoAllapot();
  }
}
