package hu.marianna;

import hu.marianna.kereso.modosithato.visszalepeses.AlapVisszalepeses;
import hu.marianna.kereso.modosithato.keresofa.Melysegi;
import hu.marianna.kereso.modosithato.keresofa.Szelessegi;
import hu.marianna.kereso.nemmodosithato.Nemmodosithato;
import hu.marianna.problema.HanoiTornyai.HanoiJatek;
import hu.marianna.problema.HaromKorso.KorsoJatek;
import hu.marianna.problema.NKiralyno.NKiralynoJatek;

public class Main {

  public static void main(String[] args) {

    NKiralynoJatek kiralynoJatek = new NKiralynoJatek();

    KorsoJatek korsoJatek = new KorsoJatek();

    HanoiJatek hanoiJatek = new HanoiJatek();

    Nemmodosithato nmk = new Nemmodosithato();

    AlapVisszalepeses alapVisszalepeses = new AlapVisszalepeses();

    Szelessegi szelessegi = new Szelessegi();

    Melysegi melysegi = new Melysegi();

    szelessegi.keres(hanoiJatek);

  }
}
