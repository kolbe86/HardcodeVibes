package de.nak.librarymgmt.service;
 
import java.util.Comparator;

import de.nak.librarymgmt.model.ProbeBuch;
 
public class ProbeBuchVerlagComparator implements Comparator<ProbeBuch> {
 
  @Override
  public int compare(ProbeBuch b1, ProbeBuch b2) {
    if (b1.getVerlag() == null && b2.getVerlag() == null) {
      return 0;
    }
    if (b1.getVerlag() == null) {
      return 1;
    }
    if (b2.getVerlag() == null) {
      return -1;
    }
    return b1.getVerlag().compareTo(b2.getVerlag());
  }
}
