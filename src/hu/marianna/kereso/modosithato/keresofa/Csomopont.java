package hu.marianna.kereso.modosithato.keresofa;

import java.util.List;
import hu.marianna.problema.Allapot;
import hu.marianna.problema.Operator;

public class Csomopont {
  public Allapot allapot;

  public Csomopont szulo;

  public Operator eloallitoOp;


  public int melyseg;

  public Csomopont(Allapot allapot, Csomopont szulo,
                   Operator eloallitoOp,
                    int melyseg) {
    this.allapot = allapot;
    this.szulo = szulo;
    this.eloallitoOp = eloallitoOp;
    this.melyseg = melyseg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Csomopont csomopont = (Csomopont) o;

    return allapot != null ? allapot.equals(csomopont.allapot) : csomopont.allapot == null;

  }

  @Override
  public int hashCode() {
    return allapot != null ? allapot.hashCode() : 0;
  }

  @Override
  public String toString() {
    return allapot.toString();
  }

  public String megoldasString() {
    StringBuilder sb = new StringBuilder();

    sb.append(allapot.toString());

    if (szulo != null) {
      sb.append("\nˇˇˇˇˇˇˇ\n");
      sb.append(szulo.megoldasString());
    }

    return sb.toString();
  }
}
