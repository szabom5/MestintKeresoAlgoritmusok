package hu.marianna.problema;

public interface Operator {

  int koltseg();

  boolean alkalmazhato(Allapot allapot);

  Allapot alkalmaz(Allapot eredetiAllapot);
}
