package hu.marianna.kereso.modosithato.visszalepeses;

import java.util.ArrayList;
import java.util.List;
import hu.marianna.kereso.Kereso;
import hu.marianna.problema.Allapot;
import hu.marianna.problema.Jatek;
import hu.marianna.problema.Operator;

public class AlapVisszalepeses implements Kereso {

  //adatbazis
  private Csomopont aktualis;

  @Override
  public void keres(Jatek jatek) {
    List<Operator> alkalmazhato = new ArrayList<>();
    for (Operator o : jatek.operatorok()) {
      if (o.alkalmazhato(jatek.kezdoAllapot())) {
        alkalmazhato.add(o);
      }
    }

    boolean vanMegoldas = true;

    //1. inicializalas
    aktualis = new Csomopont(jatek.kezdoAllapot(), null, null, alkalmazhato);

    //2. celfeltetel vizsgalat
    while (!aktualis.allapot.celAllapot()) {
      System.out.println(aktualis.toString());

      //3. van-e az aktualis allapotra alkalmazhato operator
      if (aktualis.nemAlkalmazottOp.size() != 0) {

        Operator alkalmazottOp = aktualis.nemAlkalmazottOp.get(0);

        Allapot ujAllapot = alkalmazottOp.alkalmaz(aktualis.allapot);

        aktualis.nemAlkalmazottOp.remove(alkalmazottOp);

        List<Operator> alkalmazhatoOperatorok = new ArrayList<>();
        for (Operator o : jatek.operatorok()) {
          if (o.alkalmazhato(ujAllapot)) {
            alkalmazhatoOperatorok.add(o);
          }
        }

        aktualis = new Csomopont(ujAllapot, aktualis, alkalmazottOp, alkalmazhatoOperatorok);

      } else if (aktualis.szulo != null) {
          //visszalepes
          aktualis = aktualis.szulo;
      }else{
        vanMegoldas = false;
        break;
      }
    }

    if (vanMegoldas) {
      System.out.println("A megoldás:\n");
      System.out.println(aktualis.megoldasString());
      System.out.println("Van megoldás");
    } else {
      System.out.println("Nincs megoldás");
    }

  }
}
