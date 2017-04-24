package hu.marianna;

import hu.marianna.kereso.modosithato.AlapVisszalepeses;
import hu.marianna.kereso.nemmodosithato.Nemmodosithato;
import hu.marianna.problema.NKiralyno.NKiralynoJatek;

public class Main {

  public static void main(String[] args) {

    NKiralynoJatek kiralynoJatek = new NKiralynoJatek();

    Nemmodosithato nmk = new Nemmodosithato();

    AlapVisszalepeses alapVisszalepeses = new AlapVisszalepeses();

    alapVisszalepeses.keres(kiralynoJatek);

  }
}
