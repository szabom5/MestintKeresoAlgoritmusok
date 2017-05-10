package hu.marianna.kereso.modosithato.keresofa;

import java.util.ArrayList;
import java.util.List;
import hu.marianna.problema.Allapot;
import hu.marianna.problema.Jatek;
import hu.marianna.problema.Operator;

public class A implements KeresofavalKereso {

  //adatbazis
  public List<Csomopont> nyiltak = new ArrayList<>();

  public List<Csomopont> zartak = new ArrayList<>();

  @Override
  public void keres(Jatek jatek) {
    //1. inicializaljuk az adatbazist
    Csomopont
        start =
        new Csomopont(jatek.kezdoAllapot(), null, null, jatek.kezdoAllapot().heurisztika());
    nyiltak.add(start);

    Csomopont megoldas = null;

    boolean nincsTobbNyiltCsucs = nyiltak.size() == 0;

    //2. kilepesi feltetel vizsgalata
    while (!nincsTobbNyiltCsucs) {


      Csomopont kivalsztott =
          nyiltak.stream()
              .min((c1, c2) -> Integer.compare(c1.info, c2.info))
              .get();

      System.out.println(nyiltak.toString());

      if (kivalsztott.allapot.celAllapot()) {
        megoldas = kivalsztott;
        break;
      }

      Kiterjeszt(jatek, kivalsztott);

      nincsTobbNyiltCsucs = nyiltak.size() == 0;
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
    for (Operator o : jatek.operatorok()) {
      if (o.alkalmazhato(kiterjesztendo.allapot)) {
        Allapot ujAllapot = o.alkalmaz(kiterjesztendo.allapot);

        Csomopont
            ujCsomopont =
            new Csomopont(ujAllapot, kiterjesztendo, o,
                kiterjesztendo.info - kiterjesztendo.allapot.heurisztika() + o.koltseg() + ujAllapot
                    .heurisztika());

        //Csomopont equals method override
        if (!nyiltak.contains(ujCsomopont) && !zartak.contains(ujCsomopont)) {
          nyiltak.add(ujCsomopont);
        }
      }
    }
    nyiltak.remove(kiterjesztendo);
    zartak.add(kiterjesztendo);
  }
}
