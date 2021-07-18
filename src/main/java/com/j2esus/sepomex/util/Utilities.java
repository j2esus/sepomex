package com.j2esus.sepomex.util;

import java.text.Collator;

public class Utilities {

  public static boolean equalsIgnoreDiacritics(String s1, String s2){
    Collator collator = Collator.getInstance();
    collator.setStrength(Collator.PRIMARY);
    return collator.compare(s1, s2) == 0;
  }
}
