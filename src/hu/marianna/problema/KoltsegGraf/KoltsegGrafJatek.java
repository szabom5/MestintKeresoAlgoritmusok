package hu.marianna.problema.KoltsegGraf;

import java.util.ArrayList;
import java.util.List;
import hu.marianna.problema.Allapot;
import hu.marianna.problema.Jatek;
import hu.marianna.problema.Operator;

public class KoltsegGrafJatek implements Jatek {
  @Override
  public List<Operator> operatorok() {
    List list = new ArrayList();

    list.add(new KoltsegGrafOperator(new KoltsegGrafAllapot(0), new KoltsegGrafAllapot(1), 2));
    list.add(new KoltsegGrafOperator(new KoltsegGrafAllapot(0), new KoltsegGrafAllapot(2), 3));
    list.add(new KoltsegGrafOperator(new KoltsegGrafAllapot(1), new KoltsegGrafAllapot(3), 5));
    list.add(new KoltsegGrafOperator(new KoltsegGrafAllapot(1), new KoltsegGrafAllapot(4), 3));
    list.add(new KoltsegGrafOperator(new KoltsegGrafAllapot(2), new KoltsegGrafAllapot(4), 1));
    list.add(new KoltsegGrafOperator(new KoltsegGrafAllapot(2), new KoltsegGrafAllapot(5), 3));
    list.add(new KoltsegGrafOperator(new KoltsegGrafAllapot(3), new KoltsegGrafAllapot(6), 2));
    list.add(new KoltsegGrafOperator(new KoltsegGrafAllapot(4), new KoltsegGrafAllapot(6), 3));
    list.add(new KoltsegGrafOperator(new KoltsegGrafAllapot(4), new KoltsegGrafAllapot(7), 1));
    list.add(new KoltsegGrafOperator(new KoltsegGrafAllapot(5), new KoltsegGrafAllapot(7), 1));


    return list;
  }

  @Override
  public Allapot kezdoAllapot() {
    return new KoltsegGrafAllapot(0);
  }
}
