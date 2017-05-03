package hu.marianna.kereso.modosithato.keresofa;

import java.util.ArrayList;
import java.util.List;
import hu.marianna.problema.Allapot;
import hu.marianna.problema.Jatek;
import hu.marianna.problema.Operator;

public class Melysegi implements KeresofavalKereso {
  //adatbazis
  //a keresofat csak imitaljuk

  //VEREM adatszerkezet megvalositasa
  public List<Csomopont> nyiltak = new ArrayList<>();

  public List<Csomopont> zartak = new ArrayList<>();

  @Override
  public void keres(Jatek jatek) {
    //1. inicializaljuk az adatbazist
    Csomopont start = new Csomopont(jatek.kezdoAllapot(), null, null, 0);
    nyiltak.add(start);

    Csomopont megoldas = null;

    boolean nincsTobbNyiltCsucs = nyiltak.size() == 0;

    //2. kilepesi feltetel vizsgalata
    while (!nincsTobbNyiltCsucs) {

      nincsTobbNyiltCsucs = nyiltak.size() == 0;

      Csomopont kivalsztott = nyiltak.get(0);

      System.out.println(nyiltak.toString());

      if (kivalsztott.allapot.celAllapot()) {
        megoldas = kivalsztott;
        break;
      }

      Kiterjeszt(jatek, kivalsztott);
    }

    if (nincsTobbNyiltCsucs) {
      System.out.println("Nincs megoldás");
    } else {
      System.out.println("A megoldás:\n");
      System.out.println(megoldas.megoldasString());
      System.out.println("Van megoldás");
    }
  }


  @Override
  public void Kiterjeszt(Jatek jatek, Csomopont kiterjesztendo) {
    List<Csomopont> kiterjesztettek = new ArrayList<>();
    for (Operator o : jatek.operatorok()) {
      if (o.alkalmazhato(kiterjesztendo.allapot)) {
        Allapot ujAllapot = o.alkalmaz(kiterjesztendo.allapot);

        Csomopont
            ujCsomopont =
            new Csomopont(ujAllapot, kiterjesztendo, o, kiterjesztendo.info + 1);

        //Csomopont equals method override
        if (!nyiltak.contains(ujCsomopont) && !zartak.contains(ujCsomopont)) {
          kiterjesztettek.add(ujCsomopont);
        }
      }
    }
    nyiltak.remove(kiterjesztendo);
    nyiltak.addAll(0,kiterjesztettek);
    zartak.add(kiterjesztendo);
  }
}