package hu.marianna.problema.NKiralyno;

import hu.marianna.problema.Allapot;
import hu.marianna.problema.Operator;

public class KiralynoOperator implements Operator {
  int i;

  int j;

  public KiralynoOperator(int i, int j){
    this.i = i;
    this.j = j;
  }

  @Override
  public int koltseg() {
    return 1;
  }

  @Override
  public boolean alkalmazhato(Allapot allapot) {
    return ((KiralynoAllapot) allapot).a[i][j] == 0;
  }

  @Override
  public Allapot alkalmaz(Allapot eredetiAllapot) {
    int a[][] = ((KiralynoAllapot) eredetiAllapot).a;
    int N = a.length;

    KiralynoAllapot ujAllapot = new KiralynoAllapot();
    int b[][] = ujAllapot.a;

    for (int k = 0; k < N; ++k) {
      for (int l = 0; l < N; ++l) {

        if(k == i && l == j){
          b[k][l] = 1; //kiralyno
        }else if(k == i || l == j || Math.abs(k-i)==Math.abs(l-j)){
          b[k][l] = 2;  //ütes
        }else{
          b[k][l] = a[k][l];
        }
      }
    }

    return ujAllapot;
  }
}
