package hu.marianna.problema.NKiralyno;

import java.util.Arrays;
import hu.marianna.problema.Allapot;

public class KiralynoAllapot implements Allapot {

  public static final int N = 4;

  public int a[][];

  public KiralynoAllapot() {
    a = new int[N][N];
  }

  @Override
  public boolean celAllapot() {
    int count = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        count += (a[i][j] == 1) ? 1 : 0;
      }
    }
    return count == N;
  }

  @Override
  public int heurisztika() {
    return heurCountZeroPlus();
  }

  private int heurCountZeroPlus() {
    int countZero = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        countZero += (a[i][j] == 0)?1:0;
      }
    }

    if(a[0][0] == 2 && a[0][N-1] == 2){
      countZero++;
    }

    return countZero;
  }

  private int heurCountZero() {
    int countZero = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        countZero += (a[i][j] == 0)?1:0;
      }
    }
    return countZero;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    KiralynoAllapot that = (KiralynoAllapot) o;

    return Arrays.deepEquals(a, that.a);

  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(a);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < N; ++i) {
      sb.append("| ");
      for (int j = 0; j < N; ++j) {
        sb.append(a[i][j]);
        sb.append(" ");
      }
      sb.append("|\n");
    }
    return sb.toString();
  }
}
