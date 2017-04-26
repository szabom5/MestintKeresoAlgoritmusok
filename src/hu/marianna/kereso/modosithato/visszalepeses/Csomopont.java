package hu.marianna.kereso.modosithato.visszalepeses;

import java.util.List;
import hu.marianna.problema.Allapot;
import hu.marianna.problema.Operator;

public class Csomopont {
  public Allapot allapot;

  public Csomopont szulo;

  public Operator eloallitoOp;

  public List<Operator> nemAlkalmazottOp;

  public Csomopont(Allapot allapot, Csomopont szulo, Operator eloallitoOp,
                   List<Operator> nemAlkalmazottOp) {
    this.allapot = allapot;
    this.szulo = szulo;
    this.eloallitoOp = eloallitoOp;
    this.nemAlkalmazottOp = nemAlkalmazottOp;
  }

  @Override
  public String toString() {
      return  allapot.toString();
  }

  public String megoldasString(){
    StringBuilder sb = new StringBuilder();

    sb.append(allapot.toString());

    if(szulo != null){
      sb.append("  ˇˇˇˇˇˇˇ\n");
      sb.append(szulo.megoldasString());
    }

    return sb.toString();
  }
}
