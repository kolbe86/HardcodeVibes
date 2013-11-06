package de.nak.librarymgmt.service;
 
import java.util.Comparator;

import de.nak.librarymgmt.model.ProbeBuch;
 
public class ProbeBuchTitelComparator implements Comparator<ProbeBuch> {
 
  @Override
  public int compare(ProbeBuch b1, ProbeBuch b2) {
    if (b1.getTitel() == null && b2.getTitel() == null) {
      return 0;
    }
    if (b1.getTitel() == null) {
      return 1;
    }
    if (b2.getTitel() == null) {
      return -1;
    }
    return b1.getTitel().compareTo(b2.getTitel());
  }
}
