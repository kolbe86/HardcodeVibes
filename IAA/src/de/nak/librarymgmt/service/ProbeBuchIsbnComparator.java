package de.nak.librarymgmt.service;
 
import java.util.Comparator;

import de.nak.librarymgmt.model.ProbeBuch;
 
public class ProbeBuchIsbnComparator implements Comparator<ProbeBuch> {
 
  @Override
  public int compare(ProbeBuch b1, ProbeBuch b2) {
    if (b1.getIsbn() == null && b2.getIsbn() == null) {
      return 0;
    }
    if (b1.getIsbn() == null) {
      return 1;
    }
    if (b2.getIsbn() == null) {
      return -1;
    }
    return b1.getIsbn().compareTo(b2.getIsbn());
  }
}
