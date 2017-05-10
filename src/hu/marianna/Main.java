package hu.marianna;

import hu.marianna.kereso.modosithato.keresofa.A;
import hu.marianna.kereso.modosithato.keresofa.BestFirst;
import hu.marianna.kereso.modosithato.keresofa.Optimalis;
import hu.marianna.kereso.modosithato.visszalepeses.AlapVisszalepeses;
import hu.marianna.kereso.modosithato.keresofa.Melysegi;
import hu.marianna.kereso.modosithato.keresofa.Szelessegi;
import hu.marianna.kereso.nemmodosithato.Nemmodosithato;
import hu.marianna.problema.HanoiTornyai.HanoiJatek;
import hu.marianna.problema.HaromKorso.KorsoJatek;
import hu.marianna.problema.KoltsegGraf.KoltsegGrafAllapot;
import hu.marianna.problema.KoltsegGraf.KoltsegGrafJatek;
import hu.marianna.problema.NKiralyno.NKiralynoJatek;

public class Main {

  public static void main(String[] args) {

    NKiralynoJatek kiralynoJatek = new NKiralynoJatek();

    KorsoJatek korsoJatek = new KorsoJatek();

    HanoiJatek hanoiJatek = new HanoiJatek();

    KoltsegGrafJatek koltsegGrafJatek = new KoltsegGrafJatek();

    Nemmodosithato nmk = new Nemmodosithato();

    AlapVisszalepeses alapVisszalepeses = new AlapVisszalepeses();

    Szelessegi szelessegi = new Szelessegi();

    Melysegi melysegi = new Melysegi();

    Optimalis optimalis =  new Optimalis();

    BestFirst bestFirst = new BestFirst();

    A a = new A();

    a.keres(koltsegGrafJatek);

  }
}
