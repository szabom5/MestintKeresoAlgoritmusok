package hu.marianna.kereso.nemmodosithato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import hu.marianna.kereso.Kereso;
import hu.marianna.problema.Allapot;
import hu.marianna.problema.Jatek;
import hu.marianna.problema.Operator;

public class Nemmodosithato implements Kereso {

  //adatbazis

  Allapot aktualis;

  @Override
  public void keres(Jatek jatek) {
    boolean siker = true;
    //init
    aktualis = jatek.kezdoAllapot();

    //celfeltetel vizsgalat
    while (!aktualis.celAllapot()) {
      System.out.println(aktualis.toString());

      List<Operator> alkalmazhatoOperatorok = new ArrayList<>();
      for (Operator o : jatek.operatorok()) {
        if (o.alkalmazhato(aktualis)) {
          alkalmazhatoOperatorok.add(o);
        }
      }

      if (alkalmazhatoOperatorok.size() == 0) {
        siker = false;
        break;
      }

      Operator valasztott = valaszt(alkalmazhatoOperatorok);

      aktualis = valasztott.alkalmaz(aktualis);
    }

    if(siker){
      System.out.println(aktualis);
      System.out.println("SIKER");
    }else{
      System.out.println("SIKERTELEN");
    }
  }

  private Operator valaszt(List<Operator> list) {
    //szisztematikusan
    Operator op1 = list.get(0);

    //véletlenszeruen
    int random = ThreadLocalRandom.current().nextInt(0, list.size());
    Operator op2 = list.get(random);

    //heurisztikusan
    Operator op3 = heurisztikusanValasztott(list);

    return op3;
  }

  private Operator heurisztikusanValasztott(List<Operator> list) {
    Operator best = null;
    int min = 0;

    for (Operator o : list) {

      int h = o.alkalmaz(aktualis).heurisztika();


      if (best == null || h > min) {
        best = o;
        min = h;
      }
    }

    System.out.println(min);
    return best;
  }

}
