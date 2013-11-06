package de.nak.librarymgmt.service;
 
import java.util.Comparator;

import de.nak.librarymgmt.model.ProbeBuch;
 
public class ProbeBuchAuthorComparator implements Comparator<ProbeBuch> {
 
  @Override
  public int compare(ProbeBuch b1, ProbeBuch b2) {
    if (b1.getAuthor() == null && b2.getAuthor() == null) {
      return 0;
    }
    if (b1.getAuthor() == null) {
      return 1;
    }
    if (b2.getAuthor() == null) {
      return -1;
    }
    return b1.getAuthor().compareTo(b2.getAuthor());
  }
}
